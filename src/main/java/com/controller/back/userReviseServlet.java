package com.controller.back;

import com.entity.User;
import com.service.back.ServiceImpl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userReviseServlet", value = "/userReviseServlet")
public class userReviseServlet extends HttpServlet {

    com.service.back.userService userService=new userServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String currentPage=request.getParameter("currentPage");
        int uid=Integer.parseInt(request.getParameter("uid"));
        String uname=request.getParameter("uname");
        String upassword=request.getParameter("upassword");
        int uage=Integer.parseInt(request.getParameter("uage"));
        String usex=request.getParameter("usex");
        String uphone=request.getParameter("uphone");
        String uemail=request.getParameter("uemail");
        Double ufunds=Double.parseDouble(request.getParameter("ufunds"));
        User user=new User();
        user.setUid(uid);
        user.setUname(uname);
        user.setUage(uage);
        user.setUsex(usex);
        user.setUphone(uphone);
        user.setUemail(uemail);
        user.setUfunds(ufunds);
        user.setUpassword(upassword);
        user.setUtype(1);
        //做更新操作，将数据通过uid和条件非空后，更新到数据库当中
        userService.updateOneByUser(user);
        //数据修改更新操作完成后，应重新跳转到userManagerServlet中，展示数据，携带当前页
        request.getRequestDispatcher("userManagerServlet?currentPage="+currentPage).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
