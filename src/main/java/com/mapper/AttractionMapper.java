package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface AttractionMapper {
//    通过景点名称查找景点id
    public Integer selectAidByAname(@Param("aname") String aname);
//通过景点名称查找景点价格
    double selectApriceByAname(@Param("aname") String aname);
}
