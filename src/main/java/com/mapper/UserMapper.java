package com.mapper;

import com.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

public interface UserMapper {
    public User queryUserByUname(@Param("uname") String uname);
}
