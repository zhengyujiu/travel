package com.service.impl;

import com.entity.Order;
import com.entity.PageBean;
import com.mapper.OrderMapper;
import com.service.OrderService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class OrderServiceImpl implements OrderService {


    @Override
    public String insertOrder(Order order) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        int i = mapper.insertOrder(order);
        String msg = null;
        if (i > 0) {
            msg = "订单添加成功";
        } else {
            msg = "订单添加失败";
        }
        return msg;
    }

    @Override
    public PageBean<Order> getOrderByPage(List<Order> userOrders,PageBean pageBean) {
        pageBean.setTotalCount(userOrders.size());
        System.out.println("userOrders.size()是"+userOrders.size());
        int start=0;
        if ((pageBean.getCurrentPage()-1)*pageBean.getPageSize()<=userOrders.size()){
            start=(pageBean.getCurrentPage()-1)*pageBean.getPageSize();
        }else {
            pageBean.setCurrentPage(userOrders.size()/ pageBean.getPageSize()+1);
            start=userOrders.size()-userOrders.size()% pageBean.getPageSize();
        }

        int end=(start + pageBean.getPageSize()) <=userOrders.size()?start + pageBean.getPageSize():userOrders.size();
        List<Order> orders = userOrders.subList(start, end);

        pageBean.setList(orders);
        System.out.println(orders);
        return pageBean;
    }

    @Override
    public PageBean getOrderByAnameAndPage(PageBean pageBean, List<Order> userOrders,String aname) {
        if ((Integer)pageBean.getPageSize()==null||pageBean.getPageSize()==0){
            System.out.println("pageBean.getPageSize()==null");
            pageBean.setPageSize(5);
        }
        if ((Integer)pageBean.getCurrentPage()==null||pageBean.getCurrentPage()==0){
            pageBean.setCurrentPage(1);
        }
        List<Order> orderList=new ArrayList<>();
        for (Order order:userOrders){
            if (order.getAttraction().getAname().equals(aname)){
                orderList.add(order);
            }
        }
        System.out.println("orderList的size是(totalCount)"+orderList.size());
        int start=0;
        if ((pageBean.getCurrentPage()-1)*pageBean.getPageSize()<=orderList.size()){
            start=(pageBean.getCurrentPage()-1)*pageBean.getPageSize();
        }else {
            pageBean.setCurrentPage(orderList.size()/ pageBean.getPageSize()+1);
            start=orderList.size()-orderList.size()% pageBean.getPageSize();
        }
        int end=(start + pageBean.getPageSize()) <=orderList.size()?start + pageBean.getPageSize():orderList.size();
        List<Order> orders = orderList.subList(start, end);
        pageBean.setList(orders);
        pageBean.setTotalCount(orderList.size());
        return pageBean;
    }
}
