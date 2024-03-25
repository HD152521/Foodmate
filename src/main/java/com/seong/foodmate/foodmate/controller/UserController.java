package com.seong.foodmate.foodmate.controller;

import org.springframework.boot.SpringApplication;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.util.JSONPObject;
import com.seong.foodmate.foodmate.FoodmateApplication;
import com.seong.foodmate.foodmate.service.UserService;
import com.seong.foodmate.foodmate.vo.UserVO;

import jakarta.servlet.http.HttpSession;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class UserController {
	@Autowired
	private UserService userService;

	@GetMapping("/signup")
    public String signupPage() {  // 회원 가입 페이지
		// Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		System.out.println("enter sign up//처음");
		// if (authentication instanceof AnonymousAuthenticationToken)
        return "signupPage";
		// return "redirect:/";
    }
	
	//로그인 페이지
	@GetMapping("/login")
    public String loginPage() { // 로그인되지 않은 상태이면 로그인 페이지를, 로그인된 상태이면 home 페이지를 보여줌
		System.out.println("enter login page");
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if (authentication instanceof AnonymousAuthenticationToken)
			return "loginPage";
		return "redirect:/";
    }

	@PostMapping("/checkId")
	public boolean checkId(@RequestBody HashMap<String, Object> test) throws JsonMappingException, JsonProcessingException {
		System.out.println("enter check Id");

		ObjectMapper objectMapper = new ObjectMapper();
		UserVO userVo = objectMapper.convertValue(test, UserVO.class);

		String id = userVo.getId();
		return userService.checkId(id);
		//중복없으면 true 있으면 false 리턴
	}
	
	
	// 서버로 받을 때 
	
    // public String signup(@RequestBody HashMap<String, Object> test) throws JsonMappingException, JsonProcessingException { // 회원 가입
	// 	System.out.println("enter sign up / contorller");	
	// 	System.out.println("check");

	// 	System.out.println(test);

	// 	ObjectMapper objectMapper = new ObjectMapper();
	// 	UserVO userVo = objectMapper.convertValue(test, UserVO.class);;


	// 	System.out.println(userVo.getId());
	// 	System.out.println(userVo.getPasswd());
	// 	System.out.println(userVo.getName());
	// 	System.out.println("=================================");
	@PostMapping("/signupProcess")
	public String signup(UserVO userVo) throws JsonMappingException, JsonProcessingException { 
        
		System.out.println(userVo.toString());

		try {
            String msg = userService.signup(userVo);
			if(msg=="idpwnull"){
				//null값
				throw new Exception();
			}
			else if(msg == "idDuplicated"){
				//아이디 중복
				throw new Exception();
			}
        } catch (DuplicateKeyException e) {
            return "redirect:/signup?error_code=-1";
        } catch (Exception e) {
            e.printStackTrace();
            return "redirect:/signup?error_code=-99";
        }

		System.out.println("회원가입 완료");
        return "redirect:/login";
    }
}
