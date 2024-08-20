package com.example.admincontroller.app;

import com.example.R.ResponseResult;
import com.example.config.MyException;
import com.example.dto.GetComicFrom;
import com.example.dto.LoginFrom;
import com.example.pojo.Comic;
import com.example.pojo.User;
import com.example.service.ComicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 阅读漫画
 */
@RestController
@RequestMapping("/public")
@CrossOrigin
@Slf4j
public class RComicController {

    @Autowired private ComicService comicService;

    /**
     * 推荐漫画获取
     * @return
     */
    @GetMapping("/recommendComic")
    @Cacheable(value = "comic", key = "'recommendComic'", unless = "#result == null")
    public ResponseResult<List<Comic>> recommendComic() {
        List<Comic> list = comicService.list();
        log.info(list.toString());
        return  ResponseResult.success(list);
    }
    /**
     * 通过搜索数据的漫画的获取
     * @param from
     * @return
     */
    @PostMapping("/getComicByEs")
    @Cacheable(value = "getComicByes", key = "#from", unless = "#result == null")
    public ResponseResult<User> getComicByes(@RequestBody LoginFrom from ) {

        return  ResponseResult.success();
    }
    /**
     * 通过漫画id和章节id获取漫画的章节
     * @param from
     * @return
     */
    @PostMapping("/getComicById")
   @Cacheable(value = "getComicChapter", key = "#from", unless = "#result == null")
    public ResponseResult<List<String>> getComicById(@RequestBody GetComicFrom from ){
        List<String> chapter = comicService.getChapter(from);
        if (chapter == null) {
            throw new MyException("没有该章节");
        }
        return ResponseResult.success(chapter);
    }

    /**
     * 漫画目录接口
     * @param from
     * @return
     */
    @PostMapping("/ComicContext")
    @Cacheable(value = "getComicContext", key = "#from", unless = "#result == null")
    public ResponseResult<List<String>> ComicContext(@RequestBody GetComicFrom from ) {
        List<String> index = comicService.getContext(from);
        return ResponseResult.success(index);
    }
    /**
     * 分页获取搜索的漫画
     * @param from
     * @return
     */
    @PostMapping("/getComicWithLimit")
    @Cacheable(value = "getComicWithLimit", key = "'getComicWithLimit'", unless = "#result == null")
    public ResponseResult<User> getComicWithLimit(@RequestBody LoginFrom from ) {
        return  ResponseResult.success();
    }

}
