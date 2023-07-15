package com.mapper.back;

import com.entity.User;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface userMapper {

        int getAllCount();

        List<User> getAllUserInfo(@Param("start")int start,@Param("pageSize")int pageSize);

        void deleteOneByUid(String uid);

        void updateOneByUser(User user);

        void insertOneUser(User user);

}
