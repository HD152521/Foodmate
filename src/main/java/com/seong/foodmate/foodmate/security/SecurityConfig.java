package com.seong.foodmate.foodmate.security;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.ProviderManager;
import org.springframework.security.authentication.dao.DaoAuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;

import com.fasterxml.jackson.databind.ObjectMapper;


@Configuration
@EnableWebSecurity
public class SecurityConfig{

    private final ObjectMapper objectMapper = new ObjectMapper();
    private final LoginSuccessHandler loginSuccessHandler = new LoginSuccessHandler();
    private final LoginFailureHandler loginFailureHandler = new LoginFailureHandler();
    private final UserDetailsService loginService = null;

    @Bean
        public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
            
        http
            .authorizeHttpRequests((auth) -> auth
                .requestMatchers("/login","/signup","/signupProcess","/loginProcess").permitAll()
                .requestMatchers("/").permitAll()
                // .requestMatchers("home/**").hasAnyRole("USER","ADsMIN")
                .requestMatchers("/home").hasAnyRole("USER","ADMIN")
                .requestMatchers("/admin").hasRole("ADMIN")
                // refrigerator 추가 부분
                .requestMatchers("/refrigerator/put","/refrigerator/show").hasRole("USER")
                .requestMatchers("/post/*").hasRole("USER")
                .anyRequest().authenticated()
            );

        http
            .formLogin((auth) -> auth.loginPage("/login")
                .usernameParameter("username")
                .passwordParameter("passwd")
                .loginProcessingUrl("/loginProcess")
                .defaultSuccessUrl("/")
                .permitAll()
            );
        
        http.addFilterBefore(jsonUsernamePasswordAuthenticationFilter(), UsernamePasswordAuthenticationFilter.class);

        //하나 로그인 허용, 다중로그인 접속시 기존 세션 하나 삭제
        http
            .sessionManagement((auth) -> auth
                .maximumSessions(1)
                .maxSessionsPreventsLogin(false));

        http
            .csrf((auth)->auth.disable());

        return http.build();
    }

    @Bean
    public JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter() {
        JsonUsernamePasswordAuthenticationFilter jsonUsernamePasswordAuthenticationFilter = new JsonUsernamePasswordAuthenticationFilter(objectMapper, loginSuccessHandler, loginFailureHandler);
        jsonUsernamePasswordAuthenticationFilter.setAuthenticationManager(authenticationManager());
        return jsonUsernamePasswordAuthenticationFilter;
    }

    @Bean
    public AuthenticationManager authenticationManager() {
        DaoAuthenticationProvider provider = new DaoAuthenticationProvider();

        provider.setPasswordEncoder(bCryptPasswordEncoder());
        provider.setUserDetailsService(loginService);
        
        return new ProviderManager(provider);
    }

    @Bean
    public BCryptPasswordEncoder bCryptPasswordEncoder() {
        return new BCryptPasswordEncoder();
    }
}