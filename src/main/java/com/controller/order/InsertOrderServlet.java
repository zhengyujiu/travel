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
        //从前端的session中获取aid
        if (req.getSession().getAttribute("chooseAttraction")!=null){
             aid= Integer.parseInt((String) req.getSession().getAttribute("chooseAttraction"));
        }
        //从前端的session中获取hid,判断是否为空,即用户是否下单了酒店
        Integer hid=null;
        if (req.getSession().getAttribute("chooseHotel")!=null){
            hid= Integer.parseInt((String) req.getSession().getAttribute("chooseHotel"));
        }
        //从前端的session中获取rcid,判断是否为空,即用户是否下单了餐厅
        Integer rcid=null;
        if (req.getSession().getAttribute("chooseCanteen")!=null){
            rcid= Integer.parseInt((String) req.getSession().getAttribute("chooseCanteen"));
        }
        Integer rid=null;
        if (req.getSession().getAttribute("chooseRoom")!=null){
            rid=  Integer.parseInt((String) req.getSession().getAttribute("chooseRoom"));
        }

        User user= (User) req.getSession().getAttribute("user");
        Integer uid=user.getUid();
        String ostartTime= req.getParameter("ostartTime");
        String oendTime=  req.getParameter("oendTime");
        float ototalPrice= Float.parseFloat(req.getParameter("ototalPrice")) ;
        Order order=new Order(null,aid,rid,rcid,uid,hid,ostartTime,oendTime, ototalPrice);
        //判断用户余额是否充足
        if (user.getUfunds()>=ototalPrice){
//            余额充足就下单
            String msg=orderService.insertOrder(order);
            RoomService roomService=new RoomServiceImpl();
//            修改房间状态
            roomService.setRoomState(rid);
            UserService userService=new UserServiceImpl();
            System.out.println("uid是"+uid);
            //修改用户余额
            userService.updateUfundsByUid(ototalPrice,uid);
            req.setAttribute("msg",msg);
            req.getRequestDispatcher("userjsp/userhome.jsp").forward(req,resp);
        }else {
            req.setAttribute("msg","用户余额不足");
            req.getRequestDispatcher("homeServlet").forward(req,resp);
        }

    }
}
