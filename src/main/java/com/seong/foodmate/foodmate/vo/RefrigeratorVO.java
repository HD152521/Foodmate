package com.seong.foodmate.foodmate.vo;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import com.seong.foodmate.foodmate.FoodmateApplication;

import lombok.Data;

@Data
public class RefrigeratorVO {
    private String user_id;
    private String ingredient;
    
    public String getUser_id(){
        return user_id;
    }
    public String getIngredient(){
        return ingredient;
    }

    public void setUser_id(String user_id){
        this.user_id = user_id;
    }
    public void setIngredient(String ingredient){
        this.ingredient = ingredient;
    }

    @Override
    public String toString(){
        return "Refrigerator[user_id="+user_id+"ingredient="+ingredient+"]";
    }

}