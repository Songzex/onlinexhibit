package com.example.mapper;

import com.example.pojo.Chapter;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;

/**
* @author 24022
* @description 针对表【chapter】的数据库操作Mapper
* @createDate 2024-07-06 00:02:22
* @Entity com.example.pojo.Chapter
*/
@Mapper
public interface ChapterMapper extends BaseMapper<Chapter> {

}




