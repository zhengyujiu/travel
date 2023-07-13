package com.service;

import com.entity.Order;
import com.entity.PageBean;

import java.util.List;

public interface OrderService {
    public String insertOrder(Order order);
    public  PageBean<Order> getOrderByPage(List<Order> userOrders, PageBean pageBean);

    PageBean getOrderByAnameAndPage(PageBean pageBean, List<Order> userOrders,String aname);
    PageBean getOrderByUnameAndPage(PageBean pageBean, List<Order> userOrders,String uname);

    public List<Order> queryAllOrders();

    public List<Order> queryOrderByUname(String uname);

    int deleteOrderByOid(int oid);

}
