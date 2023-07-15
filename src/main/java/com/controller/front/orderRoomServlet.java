package com.controller.front;

import com.entity.Hotel;
import com.entity.Room;
import com.service.front.frontImpl.hotelServiceImpl;
import com.service.front.frontImpl.roomServiceImpl;
import com.service.front.hotelService;
import com.service.front.roomService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderRoomServlet", value = "/orderRoomServlet")
public class orderRoomServlet extends HttpServlet {
    //在预定房间的servlet中，既会用房间信息也会查询酒店信息，所以在该servlet内，需要导入两个对象
    com.service.front.hotelService hotelService=new hotelServiceImpl();
    com.service.front.roomService roomService=new roomServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession=request.getSession();
        String username="王添";
        if ("".equals(username)) {
            request.setAttribute("IsLogin", 0);
        } else {
            request.setAttribute("IsLogin", 1);
            //向request域对象中设置属性
            request.setAttribute("username", username);
        }
        //在房间界面中，将所选酒店的名称和酒店图片显示出来
        String chooseHotel=(String)httpSession.getAttribute("chooseHotel");
        Hotel hotel=hotelService.getOneHotelByHid(Integer.parseInt(chooseHotel));
        //将查询到的酒店信息存放在request域对象中
        request.setAttribute("hotel",hotel);

        List<Room> roomList=null;
        //查询前端用户输入的所需房间类型和房间价格
        //从前端得到的QueryRoomType为乱码，不知原因，在酒店的城市查询中是可以的
        String QueryRoomType=request.getParameter("QueryRoomType");
        String QueryRoomPrice=request.getParameter("QueryRoomPrice");
        //房间类型或房间价格有一个值不为空，就需要去后端进行条件查询
        if(QueryRoomType!=null||QueryRoomPrice!=null){
            //将要查询的条件封装到对象room中进行查询
            Room room=new Room();
            if(chooseHotel!=null)
            room.setHid(Integer.parseInt(chooseHotel));
            if(QueryRoomPrice!=null)
            room.setRprice(Double.parseDouble(QueryRoomPrice));
            room.setRtype(QueryRoomType);
            //根据房间类型将查询到的所有房间信息显示到前端页面
            roomList=roomService.getSomeInfoByRoomTypePrice(room);
        }else{
            //未输入房间类型，则查询一些房间显示到前端界面
            roomList=roomService.getBeginSomeInfoByHid(Integer.parseInt(chooseHotel));
        }
        request.setAttribute("roomList",roomList);
        response.setContentType("text/html'charset=UTF-8");
        request.getRequestDispatcher("userjsp/userRoom.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
