package com.mapper;

import com.entity.Order;
import org.apache.ibatis.annotations.Param;

public interface OrderMapper {
    public int insertOrder(Order order);
}
