package com.service.back;

import com.entity.PageBean;
import com.entity.User;

public interface userService{

    int getAllCount();
    PageBean getAllUserInfo(PageBean<User> pageBean);

    void deleteOneByUid(String uid);

    void updateOneByUser(User user);

    void insertOneUser(User user);

}
