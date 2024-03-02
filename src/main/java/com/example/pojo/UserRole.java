package com.example.pojo;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;


@Data
@RequiredArgsConstructor
@AllArgsConstructor
@TableName("user_roles")
public class UserRole {
    @TableId(type = IdType.AUTO)
    private Integer id;
    private String roles;
    private Integer rid;


    public UserRole(String role, Integer id) {
    }
}
