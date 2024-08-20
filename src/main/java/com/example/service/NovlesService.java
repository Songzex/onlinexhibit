package com.example.service;

import com.example.dto.GetComicFrom;
import com.baomidou.mybatisplus.extension.service.IService;
import com.example.pojo.Novles;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;

/**
* @author 24022
* @description 针对表【novles】的数据库操作Service
* @createDate 2024-07-17 23:34:31
*/
public interface NovlesService extends IService<Novles> {
    /**
     * 读取text文档小说
     * @param file
     * @return
     */
    String updatec(MultipartFile file) throws IOException;

    /**
     * 获取目录
     * @param from
     * @return
     */
    List<String> getContext(GetComicFrom from);

    /**
     * 小说录入
     * @param i
     * @param file
     */
    void addNovles(int i, MultipartFile file) throws IOException;

    /**
     * 获取小说
     * @param
     * @param
     * @throws IOException
     */
    List<Novles> getNovles();
}
