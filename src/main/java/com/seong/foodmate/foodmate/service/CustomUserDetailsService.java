package com.seong.foodmate.foodmate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.seong.foodmate.foodmate.mapper.UserMapper;
import com.seong.foodmate.foodmate.vo.CustomUserDetails;
import com.seong.foodmate.foodmate.vo.UserVO;

@Service
public class CustomUserDetailsService implements UserDetailsService{

    @Autowired
    private UserMapper userMapper;

    @Override
    public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
        
        System.out.println("enter loadUserByUsername");
        System.out.println(id);

        UserVO findUser = userMapper.getUserById(id); 
        //이 값이 null이야     json형식이 아니어서 그럼
        System.out.println(findUser);
        System.out.println(findUser.getPasswd());
        System.out.println("id: "+findUser.getId());

        if(findUser != null){
            return new CustomUserDetails(findUser);
        }
        return null;
    }
    
}
