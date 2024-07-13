package com.example.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Chapter;
import com.example.service.ChapterService;
import com.example.mapper.ChapterMapper;
import org.springframework.stereotype.Service;

/**
* @author 24022
* @description 针对表【chapter】的数据库操作Service实现
* @createDate 2024-07-06 00:02:22
*/
@Service
public class ChapterServiceImpl extends ServiceImpl<ChapterMapper, Chapter>
    implements ChapterService{

}




