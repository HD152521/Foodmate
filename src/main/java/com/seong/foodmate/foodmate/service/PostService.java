package com.seong.foodmate.foodmate.service;

import org.apache.tomcat.util.digester.DocumentProperties.Charset;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.seong.foodmate.foodmate.mapper.PostMapper;
import com.seong.foodmate.foodmate.vo.PostContentVO;
import com.seong.foodmate.foodmate.vo.PostVO;

import groovyjarjarantlr4.v4.parse.ANTLRParser.rulePrequel_return;

import java.util.Date;
import java.util.List;
import java.text.SimpleDateFormat;
import java.util.Random;

@Service
public class PostService {
    
    @Autowired
    PostMapper postMapper;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;

    private final PasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    //게시글 추가 
    public void addPost(PostVO postvo,PostContentVO postContentvo){
        System.out.println("=======enter addPost service =========");

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        UserDetails userDetails = (UserDetails)principal; 
        String user_id = userDetails.getUsername(); 

        Date today = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        String todayFormat = dateFormat.format(today);

        postvo.setUser_Id(user_id);
        postvo.setCreatedAt(todayFormat);
        postvo.setStatus(true);

        String hash = randomStr(todayFormat);
        postvo.setPost_ID(hash);

        postContentvo.setPost_id(hash);

        System.out.println("=========exit addPost========");
        postMapper.addPost(postvo);
        postMapper.addPostContent(postContentvo);

    }

    public String randomStr(String date){
        int leftLimit = 97; // letter 'a'
        int rightLimit = 122; // letter 'z'
        int targetStringLength = 10;
        Random random = new Random();
        String generatedString = random.ints(leftLimit, rightLimit + 1)
                                    .limit(targetStringLength)
                                    .collect(StringBuilder::new, StringBuilder::appendCodePoint, StringBuilder::append)
                                    .toString();

        return bCryptPasswordEncoder.encode(date+generatedString);
    }

    //게시글 조회
    public List<PostVO> showPost(){
        List<PostVO> postList = postMapper.postList();
        System.out.println("showPost 들어옴===");
        System.out.println(postList);
        return postList;
    }

    public List<PostVO> showPostByUser(){
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        UserDetails userDetails = (UserDetails)principal; 
        String user_id = userDetails.getUsername(); 

        List<PostVO> postList = postMapper.postListByUser(user_id);
        System.out.println("showPostByUser 들어옴===");
        System.out.println(postList);
        
        return postList;
    }


    public PostVO findPostByNum(Integer num){
        PostVO postVo = postMapper.findPostByNum(num);
        return postVo;
    }
    
    public PostContentVO findContentById(String post_id){
        PostContentVO postContentVo = postMapper.findContentById(post_id);
        return postContentVo;
    }
}

