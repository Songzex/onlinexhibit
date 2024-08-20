package com.example.service;

import com.example.config.MyException;
import com.example.dto.GetComicFrom;
import com.example.pojo.Comic;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
* @author 24022
* @description 针对表【comic】的数据库操作Service
* @createDate 2024-07-05 23:58:56
*/
public interface ComicService extends IService<Comic> {
         //增加漫画
         void addComic(Comic comic);

    void addAdapter(Integer id, MultipartFile file) throws IOException;

    List<String> getChapter(GetComicFrom from) throws MyException;

    List<String> getContext(GetComicFrom from);
}
