package com.controller;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/loginServlet")
public class LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        String uname= req.getParameter("uname");
        String upassword=req.getParameter("upassword");
        if (uname==null||uname.isEmpty()||upassword==null||upassword.isEmpty()){
            req.setAttribute("msg","用户名或密码不能为空");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }

        User user = userService.queryUserByUname(uname);
        if (user==null){
            req.setAttribute("msg","用户名不存在");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            System.out.println(1);
        }else if(!user.getUpassword().equals(upassword)){
            req.setAttribute("msg","密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            System.out.println(2);
        }else if (user.getUtype()==1){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("index.jsp");
            System.out.println(3);
        }else if (user.getUtype()==0){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("index2.jsp");
            System.out.println(4);
        }
    }
}
