package com.mapper;

import com.entity.Order;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface OrderMapper {
    public int insertOrder(Order order);
    public List<Order> queryAllOrders();
    public List<Order> queryOrderByUname(@Param("uname") String uname);

    int deleteOrderByOid(@Param("oid") int oid);

    int updateOrderByOid(@Param("oid") Integer oid,@Param("aid")Integer aid,@Param("rid")Integer rid,@Param("rcid")Integer rcid,
                         @Param("uid")Integer uid,@Param("hid")Integer hid,@Param("ostartTime")String ostartTime,
                         @Param("oendTime")String oendTime,@Param("ototalPrice")float ototalPrice);

    Order selectOrderByOid(@Param("oid") int oid);
}
