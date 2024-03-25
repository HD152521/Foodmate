package com.seong.foodmate.foodmate.vo;

import java.sql.Date;

import org.springframework.boot.SpringApplication;
import com.seong.foodmate.foodmate.FoodmateApplication;

import lombok.Data;

@Data
public class UserVO {
    private String id;
    private String passwd;
    private String name;
    private String joindate;
    private String role;

    // 추가 부분
    private String nickname;
    private String birth;
    private String email;

    public String getEmail() {
        return this.email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getId() {
        return id;
    }
    public String getPasswd() {
        return passwd;
    }
    public String getName() {
        return name;
    }
    public String getJoinDate() {
        return joindate;
    }
    public String getRole(){
        return role;
    }
    public String getNickname(){
        return nickname;
    }
    public String getBirth(){
        return birth;
    }

    public void setId(String id) {
        this.id = id;
    }
    public void setPasswd(String passwd) {
        this.passwd = passwd;
    }
    public void setName(String name) {
        this.name = name;
    }
    public void setJoinDate(String joindate) {
        this.joindate = joindate;
    }
    public void setRole(String role){
        this.role = role;
    }
    public void setNickname(String nickname){
        this.nickname = nickname;
    }
    public void setBirth(String birth){
        this.birth = birth;
    }

    @Override
    public String toString(){
        return "UserVO [id=" + id + ", password=" + passwd + ", name=" + name +", nickname=" + nickname +", birth=" + birth+", email=" + email+", joinDate=" + joindate + ", role=" + role + "]";
    }
}
