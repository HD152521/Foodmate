package com.seong.foodmate.foodmate.controller;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.boot.SpringApplication;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.seong.foodmate.foodmate.FoodmateApplication;

@Controller
public class HomeController {

    @RequestMapping("/test")
    public String getIndex(){
        System.out.println("test in");
        return "test";
    }

    @RequestMapping("home")
    public String home(){

        
        return "home";
    }

    @GetMapping("/")
	public String index(Model model){
		System.out.println("enter home");

        String id = SecurityContextHolder.getContext().getAuthentication().getName();

        
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iter = authorities.iterator();
        GrantedAuthority auth = iter.next();
        String role = auth.getAuthority();

        model.addAttribute("id",id);
        model.addAttribute("role",role);
        

		return "index";
	}
}