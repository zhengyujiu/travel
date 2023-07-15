package com.mapper.front;

import com.entity.Attraction;
import com.entity.Comment;
import com.entity.User;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注意在dao层处写mybatis执行sql的接口方法，在对应的xml文件中写sql语句
public interface commentMapper {

    int getAllCount(int uid);

    List<Comment> getAllCommentInfo(@Param("start")int start, @Param("pageSize")int pageSize,@Param("uid")int uid);

    void deleteOneByCid(String cid);

    void insertOneComment(Comment comment);

}
