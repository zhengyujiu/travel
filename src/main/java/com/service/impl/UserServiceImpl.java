package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.message.ReusableMessage;

public class UserServiceImpl implements UserService {
    @Override
    public User queryUserByUname(String uname) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByUname(uname);
        System.out.println(uname+"*****");
        System.out.println(user);
        return user;
    }
    public User queryUserByUphone(String uphone){
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByUphone(uphone);
        return user;
    }

    @Override
    public User queryUserByUemail(String uemail) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByUemail(uemail);
        return user;
    }

    @Override
    public int insertUser(User user) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.insertUser(user);
        return i;
    }
}
