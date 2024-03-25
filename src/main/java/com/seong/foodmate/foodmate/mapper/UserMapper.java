package com.seong.foodmate.foodmate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.boot.SpringApplication;
import com.seong.foodmate.foodmate.FoodmateApplication;
import com.seong.foodmate.foodmate.vo.UserVO;

@Mapper
public interface UserMapper {
    void insertUser(UserVO userVo); // 회원 가입
    // List<UserVO> getUserList(); // User 테이블 가져오기
    // UserVO getUserByEmail(String email); // 회원 정보 가져오기
    UserVO getUserById(String id);
    // void updateUser(UserVO userVo); // 회원 정보 수정
    // void deleteUser(Long id); // 회원 탈퇴
}
