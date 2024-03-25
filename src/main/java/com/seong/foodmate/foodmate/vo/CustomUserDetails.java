package com.seong.foodmate.foodmate.vo;

import java.util.ArrayList;
import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

public class CustomUserDetails implements UserDetails {
    
    //각각 계정 권한 부여하는 페이지

    private UserVO userVo;
    
    public CustomUserDetails(UserVO userVo){
        System.out.println("enter CustomUserDetails");
        this.userVo = userVo;
        System.out.println(userVo.getId());
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        // TODO Auto-generated method stub
        //사용자 권한 리턴

        Collection<GrantedAuthority> collection = new ArrayList<>();

        System.out.println("enter collections");
        
        collection.add(new GrantedAuthority() {
            
            @Override
            public String getAuthority(){
                return userVo.getRole();
            }

        });

        return collection;
    }

    @Override
    public String getPassword() {
        // TODO Auto-generated method stub
        return userVo.getPasswd();
    }

    @Override
    public String getUsername() {
        // TODO Auto-generated method stub
        return userVo.getId();
    }

    @Override
    public boolean isAccountNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    //아이디 잠겼는지
    @Override
    public boolean isAccountNonLocked() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        // TODO Auto-generated method stub
        return true;
    }

    @Override
    public boolean isEnabled() {
        // TODO Auto-generated method stub
        return true;
    }
    
}
