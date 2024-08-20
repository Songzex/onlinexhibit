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
@Document(collection = "comicCollection")
public class MongoChapter {
    @Id
    private  String  id;  //文档id
    private  String  comicID; //所属漫画id
    private  String titile;//章节的id序列
    private List<String> url;//本节的漫画url

}
