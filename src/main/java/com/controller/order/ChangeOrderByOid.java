package com.controller.order;

import com.entity.Room;
import com.service.*;
import com.service.impl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.io.IOException;
import java.sql.RowId;

@WebServlet("/changeOrderByOid")
public class ChangeOrderByOid extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        OrderService orderService=new OrderServiceImpl();
        AttractionService attractionService=new AttractionServiceImpl();
        HotelService hotelService=new HotelServiceImpl();
        CanteenService canteenService=new CanteenServiceImpl();
        RoomService roomService=new RoomServiceImpl();
        UserService userService=new UserServiceImpl();
        Integer aid;
        Integer hid;
        Integer rcid;
       //获取管理员传来的信息
        Integer oid= Integer.parseInt(req.getParameter("oid"));//一定不为空
        Integer uid= Integer.parseInt(req.getParameter("uid"));//一定不为空
        System.out.println(req.getParameter("rid")+"rid ********");
        Integer rid= Integer.parseInt(req.getParameter("rid"));//可能为空
        String aname=req.getParameter("aname");//可能为空
        String hname=req.getParameter("hname");//可能为空
        String rcname=req.getParameter("rcname");//可能为空
        String ostartTime=req.getParameter("ostartTime");//一定不为空
        System.out.println("ostartTIme:"+ostartTime);
        String oendTime=req.getParameter("oendTime");
        System.out.println("oendtime:"+oendTime);

        float ototalPrice= Float.parseFloat(req.getParameter("ototalPrice"));
        System.out.println("oldOtotalPrice:"+req.getParameter("oldOtotalPrice"));
        //获取用户之前订单所花费的金额
        float oldOtotalPrice= Float.parseFloat(req.getParameter("oldOtotalPrice"));
        String changeMsg=null;
        //判断管理员填写的景点是否存在,不存在就返回前端,并传回错误消息
        aid=attractionService.selectAidByAname(aname);
        if(aid==null){
            System.out.println("aid==null");
            changeMsg="该景点不存在";
            req.setAttribute("changeMsg",changeMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
            return;
        }
//        判断管理员填写的酒店是否存在,不存在就返回前端,并传回错误消息
        if (hname==null||hname.isEmpty()){
            hid=null;
        }else {System.out.println(3);
            hid=hotelService.selectHidByHname(hname);
            if (hid==null){
                changeMsg="该酒店不存在";
                req.setAttribute("changeMsg",changeMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
        }
//        判断管理员填写的餐厅是否存在,不存在就返回前端,并传回错误消息
        if (rcname==null||rcname.isEmpty()){
            System.out.println(4);
            rcid=null;
        }else {
            rcid=canteenService.selectRcidByRcname(rcname);
            if (rcid==null){
                changeMsg="该餐厅不存在";
                req.setAttribute("changeMsg",changeMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
        }

        //检验前端传来的rid是否正确
        //如果管理员没填写酒店,只填了房间号,就让管理员填写酒店信息
        if ((hname==null|| hname.isEmpty())&&rid!=null){
            System.out.println(5);
            changeMsg="请选择酒店";
            req.setAttribute("changeMsg",changeMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
            return;
        }
        //如果酒店名不为空,房间号也不为空就判断这个房间号是不是属于该酒店的,这个房间号是否存在
        else if (!(hname==null|| hname.isEmpty()) && rid!=null ){
            System.out.println(6);
            Room room = roomService.selectRoomByRid(rid);
            //判断这个房间是否被其他人占用了
            if (room==null||room.getRstate()==0){
                System.out.println(7);
                changeMsg="该房间不可用";
                req.setAttribute("changeMsg",changeMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
            //判断这个房间是否属于所选的酒店
            else if (room!=null&&room.getRstate()==1){
                if (room.getHid()!=hotelService.selectHidByHname(hname)){
                    changeMsg="该房间不存在";
                    req.setAttribute("changeMsg",changeMsg);
                    req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                    System.out.println(8);
                    return;
                }

            }
        }
//判断用户余额是否够
        if (userService.selectUfundsByUid(uid)+oldOtotalPrice>=ototalPrice){
            Integer i = orderService.updateOrderByOid(oid, aid, rid, rcid, uid, hid, ostartTime, oendTime, ototalPrice);
            if (i==1){
//                如果够的话就下单
                changeMsg="修改成功";
                System.out.println("设置房间的状态为1");
                //修改房间状态
                roomService.setRoomState(rid);
                //修改用户余额
                userService.updateUfundsByUid(ototalPrice-oldOtotalPrice,uid);
                req.setAttribute("changeMsg",changeMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
            else {
                changeMsg="修改失败";
                req.setAttribute("changeMsg",changeMsg);
                req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
                return;
            }
        }else {
            //用户余额不足
            changeMsg="用户余额不足";
            req.setAttribute("changeMsg",changeMsg);
            req.getRequestDispatcher("/queryOrderByPage").forward(req,resp);
            return;
        }



    }
}
