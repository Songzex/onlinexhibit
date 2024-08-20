package com.example.admincontroller.app;

import com.example.R.ResponseResult;
import com.example.pojo.Novles;
import com.example.service.NovlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/public")
@CrossOrigin
@Slf4j
//小说
public class NovelsController {

    //获取全部推荐小说api
    //查询小说目录
    //有小说目录和id查询章节内容
    //模糊查询   有参数查询指定的 漫画
    //小说收藏写操作
    //小说收藏读操作

@Autowired  private  NovlesService novlesService;

    @GetMapping("/recommendNovels")
    //@Cacheable(value = "RNovels", key = "'recommendNovels'", unless = "#result == null")
    public ResponseResult<List<Novles>> recommendNovels() {
        List<Novles> novles = novlesService.getNovles();
        log.info(novles.toString());
        return  ResponseResult.success(novles);
    }
//    @PostMapping("/getComicById")
//    @Cacheable(value = "getComicChapter", key = "#from", unless = "#result == null")
//    public ResponseResult<List<String>> getComicById(@RequestBody GetComicFrom from ){
//        List<String> chapter = comicService.getChapter(from);
//        if (chapter == null) {
//            throw new MyException("没有该章节");
//        }
//        return ResponseResult.success(chapter);
//    }



}
