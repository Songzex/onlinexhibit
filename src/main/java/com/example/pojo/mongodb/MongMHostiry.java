package com.example.pojo.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.ArrayList;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
@Document(collection = "MessageHostiry")
public class MongMHostiry {
 @Id
 private  String  id;
    /**
     * 标志
     */
 public  String fromTo;
    /**
     * 聊天集合
     */
 public ArrayList<ChatHoristry> list;


}
