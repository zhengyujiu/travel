package com.controller.back;

import com.entity.User;
import com.service.back.ServiceImpl.userServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "userAddServlet", value = "/userAddServlet")
public class userAddServlet extends HttpServlet {

    com.service.back.userService userService=new userServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //注意：为了和修改用户信息模态框做区分，每一个用户参数后面拼接字符串1
        String uname=request.getParameter("uname1");
        String upassword=request.getParameter("upassword1");
        int uage=Integer.parseInt(request.getParameter("uage1"));
        String usex=request.getParameter("usex1");
        String uphone=request.getParameter("uphone1");
        String uemail=request.getParameter("uemail1");
        Double ufunds=Double.parseDouble(request.getParameter("ufunds1"));
        User user=new User();
        user.setUname(uname);
        user.setUage(uage);
        user.setUsex(usex);
        user.setUphone(uphone);
        user.setUemail(uemail);
        user.setUfunds(ufunds);
        user.setUpassword(upassword);
        user.setUtype(1);

        //会将通过自动递增生成的主键封装到user中返回，无需返回值
        userService.insertOneUser(user);
        int count=userService.getAllCount();
        //因为double类型数据有小数点，所以先将double类型转化为int类型，再将其转换为字符串类型传参
        String currentPage=String.valueOf((int)Math.ceil(count/5.0));
        //传入新的当前页，这样在新增数据之后，会直接在最后一页中看到新增的数据
        request.getRequestDispatcher("userManagerServlet?currentPage="+currentPage).forward(request,response);
    }

    //注意新增用户表单提交使用的是post方法，注意要在doPost中调用doGet方法
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
