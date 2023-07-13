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

@WebServlet("/queryOrderByPage")
public class QueryOrdersByPage extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        OrderService orderService=new OrderServiceImpl();
        PageBean<Order> pageBean=new PageBean<>();
        String searchName = req.getParameter("searchName");
        if (searchName==null||searchName.isEmpty()){
            System.out.println("这个时候还没有searchName");
            List<Order> orderList = orderService.queryAllOrders();
            if (orderList==null||orderList.size()==0){
                pageBean.setTotalCount(0);
                pageBean.setList(null);
                pageBean.setCurrentPage(1);
                pageBean.setPageSize(5);
                req.setAttribute("pageBean",pageBean);
                req.getRequestDispatcher(  "beOrder.jsp").forward(req,resp);
            }
            else {
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
                pageBean=orderService.getOrderByPage(orderList,pageBean);
                System.out.println(pageBean.getList().size());
                req.setAttribute("pageBean",pageBean);
                req.getRequestDispatcher("beOrder.jsp").forward(req,resp);
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
            List<Order> orderList1 = orderService.queryOrderByUname(searchName);
            if (orderList1==null){
                System.out.println("orderList1 is null");
            }
            pageBean = orderService.getOrderByUnameAndPage(pageBean, orderList1, searchName);
            req.setAttribute("pageBean",pageBean);
            req.setAttribute("searchName",searchName);
            req.getRequestDispatcher("beOrder.jsp").forward(req,resp);
        }
    }
//        ********************************************
//        //这个类是用户点击了前一页后一页跳转,才到这个页面
//        OrderService orderService=new OrderServiceImpl();
//        List<Order> orderList =orderService.queryAllOrders();
//        PageBean pageBean=new PageBean();
//        String pageSize = req.getParameter("pageSize");
//        String currentPage =req.getParameter("currentPage");
//        if (currentPage!=null){
//            pageBean.setCurrentPage(Integer.parseInt(currentPage));
//        }else {
//            pageBean.setCurrentPage(1);
//        }
//        if (pageSize!=null){
//            pageBean.setPageSize(Integer.parseInt(pageSize));
//        }else {
//            pageBean.setPageSize(5);
//        }
//        pageBean=orderService.getOrderByPage(orderList,pageBean);
////        System.out.println(pageBean.getList().size());
//        req.setAttribute("pageBean",pageBean);
//        req.getRequestDispatcher("beOrder.jsp").forward(req,resp);
//    }
}
