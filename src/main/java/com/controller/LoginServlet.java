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
public class  LoginServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        UserService userService=new UserServiceImpl();
        String uname= req.getParameter("uname");
        String upassword=req.getParameter("upassword");
        //如果用户名或密码为空就返回前端
        if (uname==null||uname.isEmpty()||upassword==null||upassword.isEmpty()){
            req.setAttribute("msg","用户名或密码不能为空");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
        }
        //用用户名查询用户
        User user = userService.queryUserByUname(uname);
        //用户为空,说明用户名不存在
        if (user==null){
            req.setAttribute("msg","用户名不存在");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            System.out.println(1);

        }
        //用户名存在,判断密码是否相等
        else if(!user.getUpassword().equals(upassword)){
            req.setAttribute("msg","密码错误");
            req.getRequestDispatcher("login.jsp").forward(req,resp);
            System.out.println(2);
        }
        //判断用户类型,转到响应的页面,并将用户的信息存到session中,方便以后存取信息
        else if (user.getUtype()==1){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("homeServlet");
            System.out.println(3);
        }else if (user.getUtype()==0){
            req.getSession().setAttribute("user",user);
            resp.sendRedirect("back.jsp");
            System.out.println(4);
        }
    }
}
