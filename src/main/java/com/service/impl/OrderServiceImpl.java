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
//    根据订单id更新订单
    @Override
    public int updateOrderByOid(Integer oid,Integer aid,Integer rid,Integer rcid,Integer uid,Integer hid,String ostartTime,String oendTime,float ototalPrice) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        int i=mapper.updateOrderByOid( oid, aid, rid, rcid, uid, hid, ostartTime, oendTime, ototalPrice);
        return i;
    }
//查询所有订单
    @Override
    public List<Order> queryAllOrders() {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.queryAllOrders();
        return orderList;
    }
//插入订单信息
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
//分页查询订单
    @Override
    public PageBean<Order> getOrderByPage(List<Order> userOrders,PageBean pageBean) {
        pageBean.setTotalCount(userOrders.size());
        int start=0;
//        如果要查询的数量小于订单总数的话,就让start=pageBean.getCurrentPage()-1)*pageBean.getPageSize()
        if ((pageBean.getCurrentPage()-1)*pageBean.getPageSize()<=userOrders.size()){
            start=(pageBean.getCurrentPage()-1)*pageBean.getPageSize();
        }else {
//            查询的数量大于订单总数,则让start=最后一页刚开始的位置
            pageBean.setCurrentPage(userOrders.size()/ pageBean.getPageSize()+1);
            start=userOrders.size()-userOrders.size()% pageBean.getPageSize();
        }
//        如果 查询的数量大于订单总数则end代表最后一个订单,如果不大于的话,end就是查询的最后一个
        int end=(start + pageBean.getPageSize()) <=userOrders.size()?start + pageBean.getPageSize():userOrders.size();
        List<Order> orders = userOrders.subList(start, end);
        pageBean.setList(orders);
        System.out.println(orders);
        return pageBean;
    }

    @Override
    public PageBean getOrderByAnameAndPage(PageBean pageBean, List<Order> userOrders,String aname) {
//        判断pageBean中的pageSize是否为空,为其谁知初始值
        if ((Integer)pageBean.getPageSize()==null||pageBean.getPageSize()==0){
            pageBean.setPageSize(5);
        }
        //        判断pageBean中的currentPage是否为空,为其谁知初始值
        if ((Integer)pageBean.getCurrentPage()==null||pageBean.getCurrentPage()==0){
            pageBean.setCurrentPage(1);
        }
//        将数据库中符合的条件的订单筛选出来
        List<Order> orderList=new ArrayList<>();
        for (Order order:userOrders){
            if (order.getAttraction().getAname().equals(aname)){
                orderList.add(order);
            }
        }
        int start=0;
        if ((pageBean.getCurrentPage()-1)*pageBean.getPageSize()<=orderList.size()){
            start=(pageBean.getCurrentPage()-1)*pageBean.getPageSize();
        }else {
            pageBean.setCurrentPage(orderList.size()/ pageBean.getPageSize()+1);
            start=orderList.size()-orderList.size()% pageBean.getPageSize();
        }
        int end=(start + pageBean.getPageSize()) <=orderList.size()?start + pageBean.getPageSize():orderList.size();
//        用subList选出,当前页的订单
        List<Order> orders = orderList.subList(start, end);
//        设置pageBean中的属性值
        pageBean.setList(orders);
        pageBean.setTotalCount(orderList.size());
        return pageBean;
    }

    @Override
    public PageBean getOrderByUnameAndPage(PageBean pageBean, List<Order> userOrders, String uname) {
        if (userOrders==null){
        }
        if ((Integer)pageBean.getPageSize()==null||pageBean.getPageSize()==0){
            pageBean.setPageSize(5);
        }
        if ((Integer)pageBean.getCurrentPage()==null||pageBean.getCurrentPage()==0){
            pageBean.setCurrentPage(1);
        }
        List<Order> orderList=new ArrayList<>();
        for (Order order:userOrders){

            if (order.getUser().getUname().equals(uname)){
                orderList.add(order);
            }
        }
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
//通过用户名查找订单
    @Override
    public List<Order> queryOrderByUname(String uname) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        List<Order> orderList = mapper.queryOrderByUname(uname);
        return orderList;
    }
//通过订单id删除订单
    @Override
    public int deleteOrderByOid(int oid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        int i=mapper.deleteOrderByOid(oid);
        return i;
    }

//    通过订单id查找订单
    @Override
    public Order selectOrderByOid(int oid) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSession();
        OrderMapper mapper = session.getMapper(OrderMapper.class);
        Order order=mapper.selectOrderByOid(oid);
        return order;
    }
}
