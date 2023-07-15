package com.controller.order;

import com.entity.Order;
import com.entity.PageBean;
import com.entity.User;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchOrderByUname")
public class SearchOrderByUname extends HttpServlet {
    //这个类负责在用户点击搜索框后,跳转到这
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String uname=req.getParameter("searchName");//这个searchName是Uname
        OrderService orderService=new OrderServiceImpl();
        List<Order> orderList = orderService.queryOrderByUname(uname);
        PageBean pageBean=new PageBean();
//        //通过searchName查找特定的list并存到pageBean中
        pageBean=orderService.getOrderByUnameAndPage(pageBean,orderList,uname);
        //        存到requst作用域中并传给前端
        req.setAttribute("pageBean",pageBean);
        req.setAttribute("searchName",uname);
        req.getRequestDispatcher("beOrder.jsp").forward(req,resp);
    }
}
