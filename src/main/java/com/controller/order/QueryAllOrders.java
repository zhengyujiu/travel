package com.controller.order;

import com.entity.Order;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import org.apache.ibatis.annotations.Select;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;

//@WebServlet("/queryAllOrders")
//public class QueryAllOrders extends HttpServlet {
//    @Override
//    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        OrderService orderService=new OrderServiceImpl();
//        List<Order> orderList =orderService.queryAllOrders();
//        req.setAttribute("orderList",orderList);
//        req.getRequestDispatcher("beOrder.jsp").forward(req,resp);
//    }
//}
