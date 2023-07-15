package com.controller.front;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "cancelChooseOrderServlet", value = "/cancelChooseOrderServlet")
public class cancelChooseOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chooseAttraction=request.getParameter("chooseAttraction");
        String chooseHotel=request.getParameter("chooseHotel");
        String chooseCanteen=request.getParameter("chooseCanteen");
        String chooseRoom=request.getParameter("chooseRoom");

        HttpSession httpSession=request.getSession();
        //如果用户选择了取消当前景点/酒店/房间/餐厅的选择，则对应用户session中需要取消原来存储的数据
        if(("-1").equals(chooseAttraction)) {
            httpSession.removeAttribute("chooseAttraction");
            httpSession.removeAttribute("aname");
            request.getRequestDispatcher("arriveServlet").forward(request,response);
        }
        if(("-1").equals(chooseHotel)) {
            httpSession.removeAttribute("chooseHotel");
            httpSession.removeAttribute("hname");
            request.getRequestDispatcher("orderHotelServlet").forward(request,response);
        }
        if(("-1").equals(chooseRoom)) {
            httpSession.removeAttribute("chooseRoom");
            httpSession.removeAttribute("rtype");
            httpSession.removeAttribute("rprice");
            request.getRequestDispatcher("orderRoomServlet").forward(request,response);
        }
        if(("-1").equals(chooseCanteen)) {
            httpSession.removeAttribute("chooseCanteen");
            httpSession.removeAttribute("rcname");
            request.getRequestDispatcher("orderCanteenServlet").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
