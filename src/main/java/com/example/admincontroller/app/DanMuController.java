package com.example.admincontroller.app;

import com.example.R.ResponseResult;
import com.example.dto.AddFeedsFrom;
import com.example.pojo.Feed;
import com.example.pojo.mongodb.Danmu;
import com.example.service.DanmuService;
import com.example.service.FeedService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author 24022
 */
@RestController
@RequestMapping("/public")
@CrossOrigin
@Slf4j
public class ComicController {


    @Autowired
    private DanmuService danmuService;
    /**
     *
     *
     * 创建帖子
     * */
    @PostMapping("/adddanmu")
    public ResponseResult<List<Danmu>> addDanMu(@RequestBody Danmu danmu) {
        List<Danmu> addFeeds = danmuService.addDanMu(danmu);
        return  ResponseResult.success(addFeeds);
    }

    /**
     *
     * 获取全部的帖子+转发的帖子
     * **/
    @GetMapping("/getdanmu")
    public ResponseResult<List<Danmu>> getDanMu(@RequestParam("rid") String rid) {
        List<Danmu> objectList = danmuService.getDanMu(rid);
        return  ResponseResult.success(objectList);
    }

}
