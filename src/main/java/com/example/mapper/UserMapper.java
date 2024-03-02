package com.example.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.pojo.User;
import com.example.pojo.UserRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper  extends BaseMapper<User> {
    /**
     * 根据 email查user表的id
     * **/
    Integer getRByemail(String email);
    /**
     * 根据id查角色表的用户角色集合**/
    List<UserRole> getRoleByrid(Integer rid);
    /**注册用户**/
    void register(User user);
    /**登录 @return：password**/
    String login( String email);
    /**添加用户角色**/
    void  addRole(UserRole userRole);

}
