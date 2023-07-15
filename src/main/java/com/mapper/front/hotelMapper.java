package com.mapper.front;

import com.entity.Hotel;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

//注意在dao层处写mybatis执行sql的接口方法，在对应的xml文件中写sql语句
public interface hotelMapper {

    List<Hotel> getBeginSomeInfo();

    List<Hotel> getSomeByQueryCity(String QueryCity);

    List<Integer> getHotelsWithAttraction(@Param("chooseAttraction") Integer chooseAttraction, @Param("ahDistance") Integer ahDistance);

    List<Hotel> getHotelsByHids(List<Integer> list);

    Hotel getOneHotelByHid(Integer hid);

    @Select("select * from hotel where hid=#{hid}")
    Hotel getOneInfo(Integer hid);
}
