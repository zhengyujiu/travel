package com.controller.order;

import com.entity.Order;
import com.github.pagehelper.PageHelper;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import jdk.internal.dynalink.support.BottomGuardingDynamicLinker;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/insertOrder")
public class InsertOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService=new OrderServiceImpl();
        Integer aid=null;
        if (req.getSession().getAttribute("aid")!=null){
             aid= Integer.parseInt((String) req.getSession().getAttribute("aid"));
        }
        Integer hid=null;
        if (req.getSession().getAttribute("hid")!=null){
            hid= Integer.parseInt((String) req.getSession().getAttribute("hid"));
        }
        Integer rcid=null;
        if (req.getSession().getAttribute("rcid")!=null){
            rcid= Integer.parseInt((String) req.getSession().getAttribute("rcid"));
        }
        int rid= Integer.parseInt(req.getParameter("rid")) ;
        int uid= Integer.parseInt(req.getParameter("uid")) ;
        String ostartTime= req.getParameter("ostartTime");
        String oendTime=  req.getParameter("oendTime");
        double ototalPrice= Double.parseDouble(req.getParameter("ototalPrice")) ;
        Order order=new Order(null,aid,rid,rcid,uid,hid,ostartTime,oendTime, ototalPrice);
        System.out.println(order.toString());
        String msg=orderService.insertOrder(order);
        req.setAttribute("msg",msg);
        req.getRequestDispatcher("index.jsp").forward(req,resp);
        PageHelper.startPage(1,2);
    }
}
