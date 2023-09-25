package com.controller.order;

import com.entity.Order;
import com.entity.PageBean;
import com.entity.User;
import com.service.OrderService;
import com.service.UserService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.UserServiceImpl;
import sun.awt.image.URLImageSource;

import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Arrays;
import java.util.List;

@WebServlet("/oneUserOrderList")
public class OneUserOrderList extends HttpServlet {
    //这个类是无论用户是进行了条件搜索还是没有,只要点击了前一页和后一页和跳转页面,就跳转至此
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService=new OrderServiceImpl();
        System.out.println("sessionId:"+req.getSession().getId());
        //判断session中是否有用户的登录信息,如果没有就叫用户先去登录
        if (req.getSession().getAttribute("user")==null){
            String msg="请先登录";
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }
        User user = (User) req.getSession().getAttribute("user");
        List<Order> userOrders = user.getUserOrders();
        PageBean<Order> pageBean=new PageBean<>();
//        获取searchName
        String searchName = req.getParameter("searchName");
//        判断用户有没有填写searchNmae
        if (searchName==null||searchName.isEmpty()){
            System.out.println("这个时候还没有searchName");
//            判断当前用户的订单是否有订单
            if (userOrders==null||userOrders.size()==0){
                pageBean.setTotalCount(0);
                pageBean.setList(null);
                pageBean.setCurrentPage(1);
                pageBean.setPageSize(5);
                req.setAttribute("pageBean",pageBean);
                req.getRequestDispatcher("order.jsp").forward(req,resp);
            }
            else {
//                这是用户有订单的情况
                String pageSize = req.getParameter("pageSize") ;
                String currentPage =req.getParameter("currentPage") ;
                if (currentPage!=null){
                    pageBean.setCurrentPage(Integer.parseInt(currentPage));
                }else {
                    pageBean.setCurrentPage(1);
                }
                if (pageSize!=null){
                    pageBean.setPageSize(Integer.parseInt(pageSize));
                }else {
                    pageBean.setPageSize(5);
                }
                pageBean=orderService.getOrderByPage(userOrders,pageBean);
                req.setAttribute("pageBean",pageBean);
                req.getRequestDispatcher("order.jsp").forward(req,resp);
            }
        }else {
            //现在是有searchName的,也就是说现在正在处于对特定景点订单的查询
            System.out.println("这个时候有了searchName");
            String pageSize = req.getParameter("pageSize") ;
            String currentPage =req.getParameter("currentPage");
            if (currentPage!=null){
                pageBean.setCurrentPage(Integer.parseInt(currentPage));
            }else{
                pageBean.setCurrentPage(1);
            }
            if (pageSize!=null){
                pageBean.setPageSize(Integer.parseInt(pageSize));
            }else {
                pageBean.setPageSize(5);
            }
            //getOrderByAnameAndPage 方法用来设置pageBean的list和totalCount
            pageBean = orderService.getOrderByAnameAndPage(pageBean, userOrders, searchName);
            req.setAttribute("pageBean",pageBean);
            req.setAttribute("searchName",searchName);
            req.getRequestDispatcher("order.jsp").forward(req,resp);
        }
    }
}
