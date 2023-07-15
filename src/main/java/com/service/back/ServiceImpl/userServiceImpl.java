package com.service.back.ServiceImpl;

import com.entity.PageBean;
import com.entity.User;
import com.mapper.back.userMapper;
import com.service.back.userService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class userServiceImpl implements userService {

    @Override
    public int getAllCount() {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        userMapper userMapper = session.getMapper(userMapper.class);
        int count=userMapper.getAllCount();
        return count;
    }

    @Override
    public PageBean getAllUserInfo(PageBean<User> pageBean) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        userMapper userMapper = session.getMapper(userMapper.class);
        int count=userMapper.getAllCount();
        pageBean.setTotalCount(count);
        int start=(pageBean.getCurrentPage()-1)* pageBean.getPageSize();
        List<User> userList=userMapper.getAllUserInfo(start,pageBean.getPageSize());
        pageBean.setList(userList);
        return pageBean;
    }

    @Override
    public void deleteOneByUid(String uid) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        userMapper userMapper = session.getMapper(userMapper.class);
        userMapper.deleteOneByUid(uid);
    }

    @Override
    public void updateOneByUser(User user) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        userMapper userMapper = session.getMapper(userMapper.class);
        userMapper.updateOneByUser(user);
    }

    @Override
    public void insertOneUser(User user) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        userMapper userMapper = session.getMapper(userMapper.class);
        userMapper.insertOneUser(user);
    }
}
