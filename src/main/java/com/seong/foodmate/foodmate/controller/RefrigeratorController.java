package com.seong.foodmate.foodmate.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.seong.foodmate.foodmate.service.RefrigeratorService;
import com.seong.foodmate.foodmate.vo.RefrigeratorVO;


@RestController
public class RefrigeratorController {
    @Autowired
    private RefrigeratorService refrigeratorService;

    @PostMapping("/refrigerator/put")
    public void putIngredient(@RequestBody HashMap<String, Object> parameters){
        // 재료 추가하기 json형태로 올거임
        System.out.println("enter putIngredient controller======");

        ObjectMapper objectMapper = new ObjectMapper();
        //여튼 그 재료 목록만 json으로 받고 id값은 하나씩 넣어줘야함
        List<String> ingredientList = objectMapper.convertValue(parameters, new TypeReference<ArrayList<String>>(){});
        refrigeratorService.putIngredient(ingredientList);
    }

    // public String showIngredient(@RequestBody HashMap<String, Object> test){
    //     ObjectMapper objectMapper = new ObjectMapper();
    //     RefrigeratorVO refrigeratorVo = objectMapper.convertValue(test, RefrigeratorVO.class);
    //     String id = refrigeratorVo.getUser_id();
    
    @GetMapping("/refrigerator/show")
    public List<String> showIngredient(Authentication authentication){
        System.out.println("enter showIngredient controller=======");

        // id값만 가져오자  
        List<String> ingredientList = new ArrayList<>();
        //현재 로그인한 세션 아이디 가져옴
        UserDetails userDetails = (UserDetails) authentication.getPrincipal(); 
        ingredientList = refrigeratorService.showIngredient(userDetails.getUsername());

        return ingredientList;
    }
}
 