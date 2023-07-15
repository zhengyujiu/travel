package com.controller.front;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "cancelSuggestOrderServlet", value = "/cancelSuggestOrderServlet")
public class cancelSuggestOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        //一旦选择了取消推荐，则将session中的景点，餐厅，酒店信息删除掉，然后跳转到个性推荐中，重新进行选择
        HttpSession httpSession = request.getSession();
        httpSession.removeAttribute("chooseAttraction");
        httpSession.removeAttribute("aname");
        httpSession.removeAttribute("aprice");
        httpSession.removeAttribute("chooseHotel");
        httpSession.removeAttribute("hname");
        httpSession.removeAttribute("chooseRoom");
        httpSession.removeAttribute("rtype");
        httpSession.removeAttribute("rprice");
        httpSession.removeAttribute("chooseCanteen");
        httpSession.removeAttribute("rcname");
        request.getRequestDispatcher("suggestServlet").forward(request, response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
