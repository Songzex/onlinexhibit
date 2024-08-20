package com.example.pojo.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "novelCollection")
public class MongoNvlesChapter {
    @Id
    private  String  id;  //id（类似主键）
    private  String  novelID; //所属小说名字唯一
    private  String title;//章节的id序列 章节名字
    private  String text;//正文

}
