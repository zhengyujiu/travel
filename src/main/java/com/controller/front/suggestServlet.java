package com.controller.front;

import com.entity.Attraction;
import com.entity.Canteen;
import com.entity.Hotel;
import com.entity.Suggestion;
import com.service.front.*;
import com.service.front.frontImpl.*;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "suggestServlet", value = "/suggestServlet")
public class suggestServlet extends HttpServlet {

    com.service.front.attractionService attractionService=new attractionServiceImpl();
    com.service.front.hotelService hotelService=new hotelServiceImpl();
    com.service.front.roomService roomService=new roomServiceImpl();
    com.service.front.canteenService canteenService=new canteenServiceImpl();
    com.service.front.suggestService suggestService=new suggestServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession=request.getSession();
        String username="王添";
        if ("".equals(username)) {
            request.setAttribute("IsLogin", 0);
        } else {
            request.setAttribute("IsLogin", 1);
            request.setAttribute("username", username);
        }
        //首先得到推荐表中所有的数据信息
        List<Suggestion> suggestionList=suggestService.getAllInfo();
        //创建List<Map>集合，用于存放从三个表中读出的数据
        List<Map<String,String>> mapList=new ArrayList<Map<String,String>>();
        //将推荐表的信息依次读出并分别查询所有每条推荐记录对应的景点名称，图片，酒店名称，图片，餐厅名称，图片
        for(Suggestion suggestion:suggestionList){
            Integer aid=suggestion.getAid();
            Attraction attraction=attractionService.getOneInfo(aid);
            //注意每次只将数据放在一个map集合中，否则多个map集合，使用foreach遍历时，无法争取显示出来!!
            Map<String,String> map=new HashMap<>();
            map.put("aname",attraction.getAname());
            map.put("apicture",attraction.getApicture());
            //用Double.toString方法，将double类型转换为字符串类型
            map.put("aprice",Double.toString(attraction.getAprice()));
            map.put("aid",Integer.toString(attraction.getAid()));
            Integer hid=suggestion.getHid();
            Hotel hotel=hotelService.getOneInfo(hid);
            map.put("hname",hotel.getHname());
            map.put("hpicture",hotel.getHpicture());
            map.put("hid",Integer.toString(hotel.getHid()));
            Integer rcid=suggestion.getRcid();
            Canteen canteen=canteenService.getOneInfo(rcid);
            map.put("rcname",canteen.getRcname());
            map.put("rcpicture",canteen.getRcpicture());
            map.put("rcid",Integer.toString(canteen.getRcid()));
            mapList.add(map);
        }
        //查询所有推荐信息数据
        request.setAttribute("mapList",mapList);
        request.getRequestDispatcher("userjsp/userSuggest.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
