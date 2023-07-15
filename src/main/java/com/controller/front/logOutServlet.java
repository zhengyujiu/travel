package com.controller.front;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "logOutServlet", value = "/logOutServlet")
public class logOutServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession=request.getSession();
        //退出登录，则将此时session中记载的用户信息，登录状态全部删除，然后跳转到登录页面当中
        httpSession.removeAttribute("IsLogin");
        httpSession.removeAttribute("username");
        request.getRequestDispatcher("login.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
