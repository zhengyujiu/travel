package com.controller.front;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "chooseOrderServlet", value = "/chooseOrderServlet")
public class chooseOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chooseAttraction=request.getParameter("chooseAttraction");
        String aname=request.getParameter("aname");
        String aprice=request.getParameter("aprice");
        String chooseHotel=request.getParameter("chooseHotel");
        String hname=request.getParameter("hname");
        String chooseCanteen=request.getParameter("chooseCanteen");
        String rcname=request.getParameter("rcname");
        String chooseRoom=request.getParameter("chooseRoom");
        String rtype=request.getParameter("rtype");
        String rprice=request.getParameter("rprice");

        HttpSession httpSession=request.getSession();
        if(chooseAttraction!=null){
            httpSession.setAttribute("chooseAttraction",chooseAttraction);
            httpSession.setAttribute("aname",aname);
            httpSession.setAttribute("aprice",aprice);
            request.getRequestDispatcher("orderHotelServlet").forward(request,response);
        }
        if(chooseHotel!=null){
            httpSession.setAttribute("chooseHotel",chooseHotel);
            httpSession.setAttribute("hname",hname);
            request.getRequestDispatcher("orderRoomServlet").forward(request,response);
        }
        if(chooseCanteen!=null){
            httpSession.setAttribute("chooseCanteen",chooseCanteen);
            httpSession.setAttribute("rcname",rcname);
            request.getRequestDispatcher("orderCanteenServlet").forward(request,response);
        }
        if(chooseRoom!=null){
            httpSession.setAttribute("chooseRoom",chooseRoom);
            httpSession.setAttribute("rtype",rtype);
            httpSession.setAttribute("rprice",rprice);
            request.getRequestDispatcher("orderCanteenServlet").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
