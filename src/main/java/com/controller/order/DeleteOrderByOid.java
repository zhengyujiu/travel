package com.controller.order;

import com.entity.Order;
import com.service.OrderService;
import com.service.RoomService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.RoomServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/deleteOrderByOid")
public class DeleteOrderByOid extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
       //获取前端传来的数据,这个searchName是用来判断用户是否搜索了东西
        int oid=Integer.parseInt(req.getParameter("deleteOid"));
        String searchName=req.getParameter("searchName");
        OrderService orderService=new OrderServiceImpl();
//        先通过oid获取这个订单的所有信息包括rid,如果rid存在的话就修改房间的状态
        Order order = orderService.selectOrderByOid(oid);
        int i = orderService.deleteOrderByOid(oid);
        String deleteMsg=null;
        if (i==1){
            deleteMsg="删除成功";
            RoomService roomService=new RoomServiceImpl();
            roomService.setRoomState1(order.getRid());//删除订单成功,修改房间的信息
        }

        req.setAttribute("deleteMsg",deleteMsg);
        //searchname为空,则直接转发到分页的servlet
        if (searchName==null||searchName.isEmpty()){
            req.getRequestDispatcher("queryOrderByPage").forward(req,resp);
        }
        else {
            //searchname不为空,则带着searchName转发到searchOrderByUname
            req.getRequestDispatcher("searchOrderByUname?searchName="+searchName).forward(req,resp);
        }
    }
}
