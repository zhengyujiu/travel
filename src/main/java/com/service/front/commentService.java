package com.service.front;

import com.entity.Comment;
import com.entity.PageBean;
import com.entity.User;

public interface commentService {

    //得到某个用户的所有评论数
    int getAllCount(int uid);

    PageBean getAllCommentInfo(PageBean<Comment> pageBean,int uid);

    void deleteOneByCid(String cid);
    void insertOneComment(Comment comment);

}
