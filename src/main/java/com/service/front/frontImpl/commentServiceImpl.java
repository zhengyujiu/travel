package com.service.front.frontImpl;

import com.entity.Comment;
import com.entity.PageBean;
import com.entity.User;
import com.mapper.back.userMapper;
import com.mapper.front.commentMapper;
import com.service.front.commentService;
import com.utils.SqlSessionFactoryUtil;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.List;

public class commentServiceImpl implements commentService {

    @Override
    public int getAllCount(int uid) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        commentMapper commentMapper = session.getMapper(commentMapper.class);
        return commentMapper.getAllCount(uid);
    }

    @Override
    public PageBean getAllCommentInfo(PageBean<Comment> pageBean,int uid) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        commentMapper commentMapper = session.getMapper(commentMapper.class);
        int count=commentMapper.getAllCount(uid);
        pageBean.setTotalCount(count);
        int start=(pageBean.getCurrentPage()-1)*pageBean.getPageSize();
        List<Comment> commentList=commentMapper.getAllCommentInfo(start,pageBean.getPageSize(),uid);
        pageBean.setList(commentList);
        return pageBean;
    }

    @Override
    public void deleteOneByCid(String cid) {
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        commentMapper commentMapper = session.getMapper(commentMapper.class);
        commentMapper.deleteOneByCid(cid);
    }

    @Override
    public void insertOneComment(Comment comment){
        SqlSession session = SqlSessionFactoryUtil.getsqlSession();
        commentMapper commentMapper = session.getMapper(commentMapper.class);
        commentMapper.insertOneComment(comment);
    }
}
