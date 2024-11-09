package com.example.pojo.mongodb;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Document(collection = "Danmu")
public class FavoriteFolder {
    @Id
    private  String  id;
    public String   userid;
    public String  ResourceId;
    public String  chapter;
    public String  currendex;
    public String  type;
}
