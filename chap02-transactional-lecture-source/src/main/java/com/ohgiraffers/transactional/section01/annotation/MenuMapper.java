package com.ohgiraffers.transactional.section01.annotation;

import org.apache.ibatis.annotations.Mapper;

import java.util.List;
import java.util.Map;

@Mapper
public interface MenuMapper {
    List<Menu> selectMenuByMenuCodee(Map<String, List<Integer>> map);
}
