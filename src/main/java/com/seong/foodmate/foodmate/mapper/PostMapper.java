package com.seong.foodmate.foodmate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.seong.foodmate.foodmate.vo.PostContentVO;
import com.seong.foodmate.foodmate.vo.PostVO;

@Mapper
public interface PostMapper {
    void addPost(PostVO postvo);
    void addPostContent(PostContentVO postContentvo);
    PostVO findPostByNum(Integer num);
    PostContentVO findContentById(String post_id);
    List<PostVO> postListByUser(String user_id);
    List<PostVO> postList();
}
