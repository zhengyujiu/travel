package com.controller.front;

import com.entity.Hotel;
import com.service.front.frontImpl.hotelServiceImpl;
import com.service.front.hotelService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

@WebServlet(name = "orderHotelServlet", value = "/orderHotelServlet")
public class orderHotelServlet extends HttpServlet {

    hotelService hotelService=new hotelServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //用于判断当前用户是否已经登录 从而显示已登录或注册登录
        HttpSession httpSession=request.getSession();
        String username="王添";
        if ("".equals(username)) {
            request.setAttribute("IsLogin", 0);
        } else {
            request.setAttribute("IsLogin", 1);
            //向request域对象中设置属性
            request.setAttribute("username", username);
        }
        //首先看用户是否已经选择景点，如果已经选择景点，则将景点周围200m距离的酒店展示出来
        String chooseAttraction=(String)httpSession.getAttribute("chooseAttraction");
        //存放用于展示在订酒店jsp页面的数据
        List<Hotel> hotelList = null;
        //表示此时未选择景点，如果没有选择景点，则根据是否选择城市来进行查询
        if(chooseAttraction==null){
            //用于根据输入的城市来显示酒店数据
            String QueryCity=request.getParameter("QueryCity");
            System.out.println(QueryCity);
            //后期需考虑QueryCity无值的情况
            if(QueryCity==null||QueryCity==" "){
                hotelList=hotelService.getBeginSomeInfo();
            }else{
                hotelList=hotelService.getSomeByQueryCity(QueryCity);
            }
        }else{//如果选择了景点，则查询景点周围200米以内的酒店，将该酒店展示出来
            String ahDistance=request.getParameter("ahDistance");
            if(ahDistance==null){
                //如果选择了景点，但是未传距离，则默认距离为200米，否则根据传入的距离的值，进行查询
                ahDistance="200";
            }
            List<Integer> hotels=hotelService.getHotelsWithAttraction((Integer.parseInt(chooseAttraction)) ,Integer.parseInt(ahDistance));
            System.out.println(hotels);
            //根据查到所选择景点给定距离的附近酒店hid，来查询这些酒店的具体信息，存放到hotelList中，然后展示的前端页面中
            if(!hotels.isEmpty()) //如果查到景点附近的酒店了再去查这些酒店的具体信息，否则不去查询酒店
                hotelList=hotelService.getHotelsByHids(hotels);
            else
                hotelList=null;
        }
        //将查询到的酒店数据存放到request域对象中
        request.setAttribute("hotelList",hotelList);
        request.getRequestDispatcher("userjsp/userHotel.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
