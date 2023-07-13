package com.mapper;

import com.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    public int insertOrder(Order order);
    public List<Order> queryAllOrders();
    public List<Order> queryOrderByUname(@Param("uname") String uname);

    int deleteOrderByOid(@Param("oid") int oid);
}
