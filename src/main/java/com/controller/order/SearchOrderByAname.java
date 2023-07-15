package com.controller.order;

import com.entity.Order;
import com.entity.PageBean;
import com.entity.User;
import com.github.pagehelper.Page;
import com.service.OrderService;
import com.service.impl.OrderServiceImpl;
import org.springframework.boot.autoconfigure.security.SecurityProperties;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/searchOrderByAname")
public class SearchOrderByAname extends HttpServlet {
    //这个类负责在用户点击搜索框后,跳转到这
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException{
        String aname=req.getParameter("searchName");//这个searchName是Aname
        User user= (User) req.getSession().getAttribute("user");//
        List<Order> userOrders = user.getUserOrders();
        OrderService orderService=new OrderServiceImpl();
        PageBean pageBean=new PageBean();
        //通过searchName查找特定的list并存到pageBean中
        pageBean=orderService.getOrderByAnameAndPage(pageBean,userOrders,aname);
//        存到requst作用域中并传给前端
        req.setAttribute("pageBean",pageBean);
        req.setAttribute("searchName",aname);
        req.getRequestDispatcher("order.jsp").forward(req,resp);
    }
}
