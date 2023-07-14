package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface HotelMapper {
    public Integer selectHidByHname(@Param("hname")String hname);

}
