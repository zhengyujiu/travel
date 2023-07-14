package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface AttractionMapper {
    public Integer selectAidByAname(@Param("aname") String aname);

    double selectApriceByAname(@Param("aname") String aname);
}
