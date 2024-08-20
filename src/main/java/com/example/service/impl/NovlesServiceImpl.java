package com.example.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.dto.GetComicFrom;

import com.example.pojo.Novles;
import com.example.pojo.mongodb.MongoNvlesChapter;
import com.example.service.NovlesService;
import com.example.mapper.NovlesMapper;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.*;
import java.nio.charset.Charset;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;


/**
* @author 24022
* @description 针对表【novles】的数据库操作Service实现
* @createDate 2024-07-17 23:34:31
*/
@Service
public class NovlesServiceImpl extends ServiceImpl<NovlesMapper, Novles>
    implements NovlesService{

    @Autowired
    private MongoTemplate mongoTemplate;
    @Autowired
    private  NovlesMapper novlesMapper;
    @Override
    public String updatec(MultipartFile file) throws IOException {
        String fileName = file.getOriginalFilename();
        assert fileName != null;
        String[] split = fileName.split("\\.");
        String name = split[0];
        Charset gbk = Charset.forName("GBK");
        BufferedReader reader = new BufferedReader(new InputStreamReader(file.getInputStream(), gbk));
        String  line;
        StringBuilder context = new StringBuilder();
        while ((line = reader.readLine()) != null) {
            context.append(line).append("\n");
        }

        String text = context.toString();
        HashMap<String, String> hashMap = new HashMap<>();
        Pattern pattern = Pattern.compile("第\\s*\\d+\\s*章.*?(?=(第\\s*\\d+\\s*章|\\Z))", Pattern.DOTALL);
        Matcher matcher = pattern.matcher(text);

        while (matcher.find()) {
            String chapterContent = matcher.group();
            String[] lines = chapterContent.split("\\n", 2);
            String title = lines[0].trim();
            String content = lines.length > 1 ? lines[1].trim() : "";
            hashMap.put(title,content);
        }
       hashMap.forEach((key,values)->{
           MongoNvlesChapter mongoNvlesChapter = new MongoNvlesChapter();
           mongoNvlesChapter.setTitle(key);
           mongoNvlesChapter.setText(values);
           mongoNvlesChapter.setNovelID(name);
           mongoTemplate.insert(mongoNvlesChapter);
       });
        return "ok";
    }

    @Override
    public List<String> getContext(GetComicFrom from) {
        String comicId = from.getComicId();
        Query query = new Query(Criteria.where("novelID").is(from.getComicId()));
        System.out.println("目录"+from.getComicId());
        query.with(Sort.by(Sort.Order.asc("title")));
        List<MongoNvlesChapter> mongoChapters = mongoTemplate.find(query, MongoNvlesChapter.class);
        return mongoChapters.stream().map(MongoNvlesChapter::getTitle).collect(Collectors.toList());
    }

    @Override
    public void addNovles(int i, MultipartFile file) throws IOException {
        String originalFilename = file.getOriginalFilename();
        InputStream stream = file.getInputStream();
        //获取名字
        originalFilename = originalFilename.replaceAll(".xlsx$", "");  // 去除后缀.xlsx
        //取数据
        Workbook sheets = new XSSFWorkbook(stream);
        Sheet sheetAt = sheets.getSheetAt(0);
        for (Row row: sheetAt){//一行数据
            if (row.getRowNum()==0){
                continue;
            }
            Novles novles = new Novles();
            String name = row.getCell(0).getStringCellValue();//这一行的0号索引的值
            String author = row.getCell(1).getStringCellValue();
            String status = row.getCell(2).getStringCellValue();
            String explain = row.getCell(3).getStringCellValue();
            String type = row.getCell(4).getStringCellValue();
            String imul = row.getCell(5).getStringCellValue();
            novles.setNovletype(type);
            novles.setNovleaurthor(author);
            novles.setNovlecontext(explain);
            novles.setNovlestatus(status);
            novles.setNovlename(name);
            novles.setNovleimg(imul);
            //这一行的0号索引的值
            int insert = novlesMapper.insert(novles);
        }

    }

    @Override
    public List<Novles> getNovles() {
        return novlesMapper.selectList(new LambdaQueryWrapper<Novles>());
    }


    @Override
    public boolean save(Novles entity) {
        return super.save(entity);
    }

}




