package com.controller.order;

import com.entity.Order;
import com.entity.User;
import com.github.pagehelper.PageHelper;
import com.service.OrderService;
import com.service.RoomService;
import com.service.UserService;
import com.service.impl.OrderServiceImpl;
import com.service.impl.RoomServiceImpl;
import com.service.impl.UserServiceImpl;
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
        float ototalPrice= Float.parseFloat(req.getParameter("ototalPrice")) ;
        Order order=new Order(null,aid,rid,rcid,uid,hid,ostartTime,oendTime, ototalPrice);
        User user = (User) req.getSession().getAttribute("user");
        if (user.getUfunds()>=ototalPrice){
            String msg=orderService.insertOrder(order);
            RoomService roomService=new RoomServiceImpl();
            roomService.setRoomState(rid);
            UserService userService=new UserServiceImpl();
            System.out.println("uid是"+uid);
            userService.updateUfundsByUid(ototalPrice,uid);
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }else {

            req.setAttribute("msg","用户余额不足");
            req.getRequestDispatcher("index.jsp").forward(req,resp);
        }

    }
}
