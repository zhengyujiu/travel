package com.mapper.front;

import com.entity.Suggestion;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注意在dao层处写mybatis执行sql的接口方法，在对应的xml文件中写sql语句
public interface suggestMapper {

    @Select("select * from suggestion")
    List<Suggestion> getAllInfo();

}
