package com.seong.foodmate.foodmate.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.seong.foodmate.foodmate.mapper.RefrigeratorMapper;
import com.seong.foodmate.foodmate.vo.RefrigeratorVO;

@Service
public class RefrigeratorService {
    @Autowired
    private RefrigeratorMapper refrigeratorMapper;   

    public List<String> showIngredient(String user_id){

        List<RefrigeratorVO> refrigeratorVo = refrigeratorMapper.showIngredient(user_id);
        List<String> ingredient = new ArrayList<>();

        for(int i=0;i<refrigeratorVo.size();i++){
            ingredient.add(refrigeratorVo.get(i).getIngredient());
        }
        return ingredient;
    }

    public void putIngredient(List<String> ingredientList){
        RefrigeratorVO tmpRefrigeratorVo = new RefrigeratorVO();

        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal(); 
        UserDetails userDetails = (UserDetails)principal; 
        String user_id = userDetails.getUsername(); 

        for(int i=0;i<ingredientList.size();i++){
            tmpRefrigeratorVo.setUser_id(user_id);
            tmpRefrigeratorVo.setIngredient(ingredientList.get(i));
            refrigeratorMapper.putIngredient(tmpRefrigeratorVo);
        }
    }

}
