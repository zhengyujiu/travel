package com.service.impl;

import com.entity.Order;
import com.mapper.OrderMapper;
import com.service.OrderService;
import com.utils.SqlSessionFactoryUtil;
import org.apache.ibatis.session.SqlSession;

public class OrderServiceImpl implements OrderService {


    @Override
    public String insertOrder(Order order) {
        SqlSessionFactoryUtil sqlSessionFactoryUtil = new SqlSessionFactoryUtil();
        SqlSession session = sqlSessionFactoryUtil.getsqlSessionFactory();
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
}
