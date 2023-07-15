package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface HotelMapper {
    //    通过酒店名称查找酒店id
    public Integer selectHidByHname(@Param("hname")String hname);

}
