package com.mapper;

import org.apache.ibatis.annotations.Param;

public interface CanteenMapper {
    public Integer selectRcidByRcname(@Param("rcname")String rcname);

}
