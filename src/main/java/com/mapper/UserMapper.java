package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface UserMapper {
//    通过用户名查找用户
    public User queryUserByUname(@Param("uname") String uname);
    //    通过手机号查找用户
    public User queryUserByUphone(@Param("uphone") String uphone);
    //    通过用户邮箱查找用户
    public  User queryUserByUemail(@Param("uemail") String uemail) ;
//    插入用户信息
    public int insertUser(User user);
//根据用户id更新用户余额
    void updateUfundsByUid(@Param("ototalPrice") float ototalPrice,@Param("uid")Integer uid);
//根据用户id查找用户余额
    float selectUfundsByUid(@Param("uid") Integer uid);

/*---------------------------------------------------------------------*/

}
