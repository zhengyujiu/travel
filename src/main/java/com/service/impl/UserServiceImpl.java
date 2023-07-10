package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class UserServiceImpl implements UserService {
    @Override
    public User queryUserByUname(String uname) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByUname(uname);
        return user;
    }
}
