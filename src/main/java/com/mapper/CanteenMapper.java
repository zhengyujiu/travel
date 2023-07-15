package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface CanteenMapper {
//    通过餐厅名称查找餐厅id
    public Integer selectRcidByRcname(@Param("rcname")String rcname);

}
