package com.controller.front;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "suggestOrderServlet", value = "/suggestOrderServlet")
public class suggestOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String chooseAttraction = request.getParameter("chooseAttraction");
        String chooseHotel = request.getParameter("chooseHotel");
        String chooseCanteen = request.getParameter("chooseCanteen");
        String chooseRoom = request.getParameter("chooseRoom");
        String aname = request.getParameter("aname");
        String aprice = request.getParameter("aprice");
        String hname = request.getParameter("hname");
        String rcname = request.getParameter("rcname");
        String rtype = request.getParameter("rtype");
        String rprice = request.getParameter("rprice");

        HttpSession httpSession = request.getSession();
        //在request域对象中传入suggestOrder表示此时是通过推荐进行房间的预定，不能更换酒店。而不是通过个人选择进行房间的预定
        request.setAttribute("suggestOrder", 1);

        if (chooseAttraction != null) {
            httpSession.setAttribute("chooseAttraction", chooseAttraction);
            httpSession.setAttribute("aname",aname);
            httpSession.setAttribute("aprice",aprice);
        }
        if (chooseHotel != null) {
            httpSession.setAttribute("chooseHotel", chooseHotel);
            httpSession.setAttribute("hname",hname);
        }
        if (chooseCanteen != null) {
            httpSession.setAttribute("chooseCanteen", chooseCanteen);
            httpSession.setAttribute("rcname",rcname);
        }
        //此时已经在推荐中跳转到房间，选择了房间。之后存入到session对象后，跳转到个性推荐界面
        if (chooseRoom != null) {
            httpSession.setAttribute("chooseRoom", chooseRoom);
            httpSession.setAttribute("rtype",rtype);
            httpSession.setAttribute("rprice",rprice);
            request.getRequestDispatcher("suggestServlet").forward(request, response);
        } else {
            //此时只是将景点，餐厅，酒店通过推荐表进行了选择，其要跳转到房间servlet中，进行预定房间
            request.getRequestDispatcher("orderRoomServlet").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
