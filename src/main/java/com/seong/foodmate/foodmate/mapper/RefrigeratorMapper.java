package com.seong.foodmate.foodmate.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.seong.foodmate.foodmate.vo.RefrigeratorVO;

@Mapper
public interface RefrigeratorMapper {
    void putIngredient(RefrigeratorVO refrigeratorVo);
    List<RefrigeratorVO> showIngredient(String user_id);
}
