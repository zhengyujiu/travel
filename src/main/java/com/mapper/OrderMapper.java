package com.mapper;

import com.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
//    插入订单
    public int insertOrder(Order order);
//    查找全部的订单
    public List<Order> queryAllOrders();
//    通过用户名称查找订单
    public List<Order> queryOrderByUname(@Param("uname") String uname);
//通过订单id删除订单
    int deleteOrderByOid(@Param("oid") int oid);
//通过订单id更新订单
    int updateOrderByOid(@Param("oid") Integer oid,@Param("aid")Integer aid,@Param("rid")Integer rid,@Param("rcid")Integer rcid,
                         @Param("uid")Integer uid,@Param("hid")Integer hid,@Param("ostartTime")String ostartTime,
                         @Param("oendTime")String oendTime,@Param("ototalPrice")float ototalPrice);

    Order selectOrderByOid(@Param("oid") int oid);
}
