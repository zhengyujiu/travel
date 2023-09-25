package com.controller.order;

import com.entity.Order;
import com.entity.Room;
import com.entity.User;
import com.service.*;
import com.service.impl.*;
import org.springframework.jdbc.core.metadata.HanaCallMetaDataProvider;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.*;
import java.io.IOException;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet("/addOrderServlet")
public class AddOrderServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获得从前端传来的数据
        String uname=req.getParameter("addUname");

        String aname=req.getParameter("addAname");
        String hname=req.getParameter("addHname");
        Integer rid=null;
//        判断rid是否为空,防止强转时出现错误
        if (req.getParameter("addRid")==null||req.getParameter("addRid").isEmpty()){
            rid=null;
        }else {
            rid= Integer.valueOf(req.getParameter("addRid"));
        }

        String rcname=req.getParameter("addRcname");
        String ostartTime=req.getParameter("addOstartTime");
        String oendTime=req.getParameter("addOendTime");
        //定义addMsg,存放添加是否成功的信息和有添加失败的原因,
        String addMsg=null;
        UserService userService=new UserServiceImpl();
        AttractionService attractionService=new AttractionServiceImpl();
        HotelService hotelService=new HotelServiceImpl();
        RoomService roomService=new RoomServiceImpl();
        CanteenService canteenService=new CanteenServiceImpl();
        Integer uid=null;
        Integer aid=null;
        Integer hid=null;
        Integer rcid=null;
        //通过后台管理员传来用户名查找用户
        User user=userService.queryUserByUname(uname);
//        先判断用户存在吗,不存在的话就带着addMsg,转发到分页的servlet
        if (user==null){
            System.out.println("该用户不存在");
            addMsg="该用户不存在";
            req.setAttribute("addMsg",addMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
            return;
        }else {
            //用户存在的话,获取用户的uid
            uid=user.getUid();
        }
        //判断管理员填写的景点是否存在,不存在就返回前端,并传回错误消息
        aid=attractionService.selectAidByAname(aname);
        if (aid==null){
            System.out.println("aname:"+aname);
            addMsg="该景点不存在";
            req.setAttribute("addMsg",addMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
            return;
        }
        //判断管理员填写的酒店是否存在,不存在就返回前端,并传回错误消息
        if (hname==null || hname.isEmpty()){
            hid=null;
        }else {
            hid=hotelService.selectHidByHname(hname);
            if (hid==null){
                addMsg="该酒店不存在";
                req.setAttribute("addMsg",addMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
        }
        //判断管理员填写的餐厅是否存在,不存在就返回前端,并传回错误消息
        if (rcname==null || rcname.isEmpty()){
            rcid=null;
        }else {
            rcid=canteenService.selectRcidByRcname(rcname);
            if (rcid==null){
                addMsg="该餐厅不存在";
                req.setAttribute("addMsg",addMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
        }
//        通过rid获取room的信息
        Room room= roomService.selectRoomByRid(rid);
        //如果管理员没填写酒店,只填了房间号,就让管理员填写酒店信息
        if ((hname==null|| hname.isEmpty())&&rid!=null){
            System.out.println(5);
            addMsg="请选择酒店";
            req.setAttribute("changeMsg",addMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
            return;
        }
        //如果酒店名不为空,房间号也不为空就判断这个房间号是不是属于该酒店的,这个房间号是否存在
        else if (!(hname==null|| hname.isEmpty()) && rid!=null ){
            System.out.println(6);
            //判断这个房间是否被其他人占用了
            if (room==null||room.getRstate()==0){
                System.out.println(7);
                addMsg="该房间不可用";
                req.setAttribute("changeMsg",addMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
            //判断这个房间是否属于所选的酒店
            else if (room!=null&&room.getRstate()==1){
                if (room.getHid()!=hotelService.selectHidByHname(hname)){
                    addMsg="该房间不存在";
                    req.setAttribute("changeMsg",addMsg);
                    req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                    System.out.println(8);
                    return;
                }
                else {
                    //

                }
            }
        }

        double ototalPrice;//花费的总价格
        int days=1;
        //计算用户要旅游的天数,用于之后计算价格
        DateFormat dft = new SimpleDateFormat("yyyy-MM-dd");
        try {
            System.out.println(ostartTime+"***************");
            Date star = dft.parse(ostartTime);//开始时间
            Date endDay=dft.parse(oendTime);//结束时间
            Long starTime=star.getTime();
            Long endTime=endDay.getTime();
            Long num=endTime-starTime;//时间戳相差的毫秒数
            days= (int) (num/24/60/60/1000)+1;//天数
        } catch (ParseException e) {
            e.printStackTrace();
        }

        //通过用户名查找用户账上还有多少钱
       double aprice=attractionService.selectApriceByAname(aname);
        double rprice=0;
        if (room!=null){
            rprice=room.getRprice();
        }
        //计算总花费
        ototalPrice=days*(aprice+rprice);
    //用户的余额足以支付
        if(user.getUfunds()>=ototalPrice){
            Order order=new Order(null, aid,rid,rcid,uid,hid,ostartTime,oendTime,ototalPrice);
            OrderService orderService=new OrderServiceImpl();
            //修改用户余额
            userService.updateUfundsByUid((float) ototalPrice,uid);
            //修改房间状态为0,表示有人住了
            System.out.println("设置房间的状态为0");
            roomService.setRoomState(rid);
            addMsg = orderService.insertOrder(order);
            req.setAttribute("addMsg",addMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
        }
        //用户没钱了,不支付
        else {
            addMsg="该用户余额不足";
            req.setAttribute("addMsg",addMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
        }




    }
}
