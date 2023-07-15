package com.service.impl;

import com.entity.User;
import com.mapper.UserMapper;
import com.service.UserService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.message.ReusableMessage;

public class UserServiceImpl implements UserService {
//    通过uname查找用户
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
    //    通过手机号查找用户
    public User queryUserByUphone(String uphone){
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByUphone(uphone);
        return user;
    }
//通过电子邮件查找用户
    @Override
    public User queryUserByUemail(String uemail) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        User user = mapper.queryUserByUemail(uemail);
        return user;
    }
//插入用户的信息
    @Override
    public int insertUser(User user) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        int i = mapper.insertUser(user);
        return i;
    }
//uid更新用户的账户余额
    @Override
    public void updateUfundsByUid(float ototalPrice,Integer uid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        mapper.updateUfundsByUid(ototalPrice,uid);
    }
//通过uid查找用户的余额
    @Override
    public float selectUfundsByUid(Integer uid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil=new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        UserMapper mapper = session.getMapper(UserMapper.class);
        float v = mapper.selectUfundsByUid(uid);
        return v;
    }
}
