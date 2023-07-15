package com.mapper.front;

import com.entity.Canteen;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注意在dao层处写mybatis执行sql的接口方法，在对应的xml文件中写sql语句
public interface canteenMapper {

    List<Canteen> getBeginSomeInfo();

    List<Canteen> getSomeByQueryCity(String QueryCity);

    List<Integer> getCanteensWithAttraction(@Param("chooseAttraction") Integer chooseAttraction, @Param("ahDistance") Integer ahDistance);

    List<Canteen> getCanteensByHids(List<Integer> list);

    Canteen getOneCanteenByRcid(Integer rcid);

    @Select("select * from canteen where rcid=#{rcid}")
    Canteen getOneInfo(Integer rcid);

}
