package com.seong.foodmate.foodmate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.seong.foodmate.foodmate.service.PostService;
import com.seong.foodmate.foodmate.vo.PostContentVO;
import com.seong.foodmate.foodmate.vo.PostVO;

@Controller
public class PostController {
    @Autowired
    private PostService postService;

    @GetMapping("/post/show")
    public String showPost(Model model, Integer id){
        PostVO findPost = postService.findPostByNum(id);
        PostContentVO findContent = postService.findContentById(findPost.getPost_ID());
        model.addAttribute("board", findPost);
        model.addAttribute("content", findContent);
        return "boardview"; 
    }   

    @GetMapping("/post/list")
    public String postList(Model model){
        model.addAttribute("board",postService.showPost());
        return "boardlist";
    }

    @GetMapping("/post/listUser")
    public String postListByUser(Model model){
        model.addAttribute("board",postService.showPostByUser());
        return "boardlist";
    }

    @PostMapping("/post/edit")
    public String editPost(){
        //post보여주기
        return "";
    }

    @GetMapping("/post/add")
    public String addPost(){
        System.out.println("======게시물 추가 페이지 들어옴======");
        return "makePost";
    }

    @PostMapping("/post/addPostProcess")
    public String addPostProcess(PostVO postVo, PostContentVO postContentVo){
        System.out.println(postVo.toString());
        System.out.println(postContentVo.toString());
        System.out.println("========enter postContorller========");

        postService.addPost(postVo,postContentVo);

        return "redirect:/";
    }

    

    @PostMapping("/post/search")
    public String searchPost(){
        return "";
    }

    @PostMapping("/post/click")
    public String clickPost(){
        return "";
    }
}
