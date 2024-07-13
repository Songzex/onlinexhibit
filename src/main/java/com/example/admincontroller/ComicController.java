package com.example.admincontroller;

import com.example.R.ResponseResult;
import com.example.dto.LoginFrom;
import com.example.pojo.Comic;
import com.example.pojo.User;
import com.example.service.ComicService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.nio.channels.MulticastChannel;

@RestController
@RequestMapping("/public")
@CrossOrigin
@Slf4j
public class ComicController {
  @Autowired
  private ComicService comicService;


   /**
    * 导入漫画单个手导入
    * @param comic
    * @return
    */
  @PostMapping("/addComic")
  public ResponseResult<User> addComic(@RequestBody Comic comic ) {
      comicService.addComic(comic);
      log.info(comic.getAuthor());
   return  ResponseResult.success();
  }

   /**
    * 导入章节数据
    * @param from
    * @return
    */
   @PostMapping("/addAdapter")
   public ResponseResult<User> addAdapter(@RequestParam("file") MultipartFile file ) throws IOException {
        comicService.addAdapter(1,file);
      return  ResponseResult.success();
   }

   /**
    * 修改漫画的状态
    * @param from
    * @return
    */
   @PostMapping("/updateComic")
   public ResponseResult<User> updateComic(@RequestBody LoginFrom from ) {
      return  ResponseResult.success();
   }

   /**
    * 删除漫画
    * @param from
    * @return
    */
   @PostMapping("/deleteComic")
   public ResponseResult<User> deleteComic(@RequestBody LoginFrom from ) {
      return  ResponseResult.success();
   }

   /**
    * 修改章节
    * @param from
    * @return
    */
   @PostMapping("/updateChapter")
   public ResponseResult<User> updateChapter(@RequestBody LoginFrom from ) {
      return  ResponseResult.success();
   }

   /**
    * 设置推荐栏的漫画操作
    * @param from
    * @return
    */
   @PostMapping("/recommendComic")
   public ResponseResult<User> recommendComic(@RequestBody LoginFrom from ) {

      return  ResponseResult.success();
   }
}
