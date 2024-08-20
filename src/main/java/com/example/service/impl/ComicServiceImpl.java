package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Optional;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.config.MyException;
import com.example.dto.GetComicFrom;
import com.example.pojo.Comic;
import com.example.pojo.mongodb.MongoChapter;
import com.example.service.ComicService;
import com.example.mapper.ComicMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
* @author 24022
* @description 针对表【comic】的数据库操作Service实现
* @createDate 2024-07-05 23:58:56
*/
@Service
public class ComicServiceImpl extends ServiceImpl<ComicMapper, Comic>
    implements ComicService{
  @Autowired
  private  ComicMapper comicMapper;


  @Autowired
  private MongoTemplate mongoTemplate;
    @Override
    public void addComic(Comic comic) {
        comicMapper.insert(comic);
    }
  @Override
  public void addAdapter(Integer id, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
       InputStream stream = file.getInputStream();
       //获取名字
      originalFilename = originalFilename.replaceAll(".xlsx$", "");  // 去除后缀.xlsx
      String[] parts = originalFilename.split("_");
      String chapters = parts[1];
      String comicName = parts[0];
      System.out.println(comicName+"  "+chapters);
      //取数据
      Workbook sheets = new XSSFWorkbook(stream);
      Sheet sheetAt = sheets.getSheetAt(0);
      MongoChapter chapter = new MongoChapter();
      ArrayList<String> list = new ArrayList<>();
      for (Row row: sheetAt){
     if (row.getRowNum()==0){
       continue;
     }
      int cellValue = (int)row.getCell(0).getNumericCellValue();//这一行的0号索引的值
     chapter.setTitile("第"+chapters+"话");
      String cellValue1 = row.getCell(1).getStringCellValue();//这一行的0号索引的值
      list.add(cellValue1);
    }
      chapter.setUrl(list);
      Integer cid = comicMapper.selectOne(new LambdaQueryWrapper<Comic>().eq(Comic::getTitle, comicName)).getComicid();
      chapter.setComicID(String.valueOf(cid));
      MongoChapter insert = mongoTemplate.insert(chapter);
  }

    @Override
    public List<String> getChapter(GetComicFrom from) {
        Query query = new Query(Criteria.where("comicID").is(from.getComicId()).and("titile").is(from.getChapter()));
            if( mongoTemplate.findOne(query, MongoChapter.class)==null){
                return null;
            }else {
                return  mongoTemplate.findOne(query, MongoChapter.class).getUrl();
            }
    }

    @Override
    public List<String> getContext(GetComicFrom from) {
        Query query = new Query(Criteria.where("comicID").is(from.getComicId()));
        System.out.println("目录"+from.getComicId());
        query.with(Sort.by(Sort.Order.asc("titile")));
        List<MongoChapter> mongoChapters = mongoTemplate.find(query, MongoChapter.class);
        return mongoChapters.stream().map(MongoChapter::getTitile).collect(Collectors.toList());
    }
}




