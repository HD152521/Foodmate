package com.seong.foodmate.foodmate.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.seong.foodmate.foodmate.FoodmateApplication;

import com.seong.foodmate.foodmate.mapper.UserMapper;
import com.seong.foodmate.foodmate.vo.UserVO;

import java.util.Date;
import java.text.SimpleDateFormat;



@Service
public class UserService {
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();


    public String signup(UserVO uservo){
        System.out.println("enter sign up / service");
        System.out.println(uservo.getId());
		System.out.println(uservo.getPasswd());
		System.out.println(uservo.getName());

        System.out.println("birth:"+uservo.getBirth());
		System.out.println("=================================");

        //회원가입 아이디 중복 확인
        if(userMapper.getUserById(uservo.getId()) != null){
            return "idDuplicated";
        }

        //현재시간
		Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");

        if (!uservo.getId().equals("") && !uservo.getName().equals("")) {
		    // password는 암호화해서 DB에 저장           
            uservo.setPasswd(bCryptPasswordEncoder.encode(uservo.getPasswd()));
            uservo.setJoinDate(dateFormat.format(today));
            uservo.setRole("ROLE_USER");
            userMapper.insertUser(uservo);
            return "success";
        }
        return "idpwnull";
    }

    public boolean checkId(String id){
        System.out.println("service/checkid");
        UserVO uservo = userMapper.getUserById(id); 
        System.out.println("service / "+uservo.getId());
        if(uservo == null){
            return true;
        }
        else return false;
    }

    // public static String login(String id, String passwd){
    //     UserVO userVo = usermapper.getUserById(id);
    //     if(userVo.getPasswd().equals(passwd)){
    //         return userVo.getId();
    //     }
    //     return null;
    // }
}
