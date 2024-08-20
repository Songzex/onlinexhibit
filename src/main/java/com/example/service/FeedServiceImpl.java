package com.example.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.pojo.Feed;
import com.example.service.FeedService;
import com.example.mapper.FeedMapper;
import org.springframework.stereotype.Service;

/**
* @author 24022
* @description 针对表【feed】的数据库操作Service实现
* @createDate 2024-08-20 10:22:35
*/
@Service
public class FeedServiceImpl extends ServiceImpl<FeedMapper, Feed>
    implements FeedService{

}




