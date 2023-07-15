package com.mapper.front;

import com.entity.Attraction;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注意在dao层处写mybatis执行sql的接口方法，在对应的xml文件中写sql语句
public interface attractionMapper {
    List<Attraction> getBeginSomeInfo();
    List<String> getAllTypesInfo();
    List<Attraction> getAllInfoByType(String atype);
    List<Attraction> getSomeByQueryCity(String acity);

    @Select("select * from attraction where aid=#{aid}")
    Attraction getOneInfo(Integer aid);

}
