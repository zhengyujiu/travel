package com.controller;

import com.entity.User;
import com.service.UserService;
import com.service.impl.UserServiceImpl;

import javax.annotation.Resource;
import javax.jws.soap.SOAPBinding;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/registerServlet")
public class RegisterServet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//       从前端获取参数
        UserService userService=new UserServiceImpl();
        String registerMsg=null;
        String uname=req.getParameter("uname");
        String upassword=req.getParameter("upassword");
        String uphone=req.getParameter("uphone");
        String uemail=req.getParameter("uemail");
      //判断用户名是否存在
        if (userService.queryUserByUname(uname)!=null){
            registerMsg="用户名已存在";
            req.setAttribute("registerMsg",registerMsg);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }else if (userService.queryUserByUphone(uphone)!=null){
            //判断手机号是否被注册了
            registerMsg="手机号已被注册";
            req.setAttribute("registerMsg",registerMsg);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }else if (userService.queryUserByUemail(uemail)!=null){
            //判断邮箱是否被注册了
            registerMsg="邮箱已被注册";
            req.setAttribute("registerMsg",registerMsg);
            req.getRequestDispatcher("register.jsp").forward(req,resp);
        }else {
            //将注册页面的信息,封装成user,然后装进数据库
            User user=new User(null,uname,upassword,null,null,1,uphone,uemail,0);
            System.out.println(user.getUname()+"*******");
            int i = userService.insertUser(user);
            if (i==1){
//                用户增加成功的情况
                registerMsg="注册成功";
                req.setAttribute("registerMsg",registerMsg);
                req.getSession().setAttribute("registerMsg",registerMsg);
                resp.sendRedirect("login.jsp");
            }else {
                registerMsg="注册失败";
                req.setAttribute("registerMsg",registerMsg);
                req.getRequestDispatcher("register.jsp").forward(req, resp);
            }
        }

    }
}

