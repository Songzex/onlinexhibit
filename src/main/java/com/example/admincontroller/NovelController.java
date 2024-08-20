package com.example.admincontroller;

import com.example.R.ResponseResult;
import com.example.dto.GetComicFrom;
import com.example.pojo.User;
import com.example.service.NovlesService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

@RestController
@RequestMapping("/public")
@CrossOrigin
@Slf4j
public class NovelController {
    @Autowired
    NovlesService novlesService;

    /**
     *章节的导入
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/addNovelAdapter")
    public ResponseResult<Object> addAdapter(@RequestParam("file") MultipartFile file ) throws IOException {
         String  meaasge= novlesService.updatec(file);
        return  ResponseResult.success(meaasge);
    }

    /**
     * 获取小说的目录
     * @param from
     * @return
     */
    @PostMapping("/NovelContext")
    public ResponseResult<List<String>> ComicContext(@RequestBody GetComicFrom from ) {
        List<String> index = novlesService.getContext(from);
        return ResponseResult.success(index);
    }

    /**
     * 小说添加
     * @param file
     * @return
     * @throws IOException
     */
    @PostMapping("/addNovle")
    public ResponseResult<User> addNovles(@RequestParam("file") MultipartFile file ) throws IOException {
        novlesService.addNovles(1,file);
        return  ResponseResult.success();
    }







}
