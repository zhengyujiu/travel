package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    public User queryUserByUname(@Param("uname") String uname);
    public User queryUserByUphone(@Param("uphone") String uphone);

    public  User queryUserByUemail(@Param("uemail") String uemail) ;
    public int insertUser(User user);

    void updateUfundsByUid(@Param("ototalPrice") float ototalPrice,@Param("uid")Integer uid);

    float selectUfundsByUid(@Param("uid") Integer uid);
}
