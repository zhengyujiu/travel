package com.controller.front;

import com.entity.Comment;
import com.entity.PageBean;
import com.service.front.frontImpl.commentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "myCommentServlet", value = "/myCommentServlet")
public class myCommentServlet extends HttpServlet {
    com.service.front.commentService commentService=new commentServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage=request.getParameter("currentPage");
        //如果用户登录，用户id存放在session当中，直接通过session读取到
        HttpSession httpSession=request.getSession();
        int uid=Integer.parseInt(httpSession.getAttribute("uid").toString());
        System.out.println(uid);
        String pageSize=request.getParameter("pageSize");
        PageBean<Comment> pageBean=new PageBean<>();
        if(currentPage!=null){
            pageBean.setCurrentPage(Integer.parseInt(currentPage));
        }else{
            pageBean.setCurrentPage(1);
        }
        //如果传入的页的大小为空，则设置要展示的页的大小为5
        if(pageSize!=null){
            pageBean.setPageSize(Integer.parseInt(pageSize));
        }else{
            pageBean.setPageSize(5);
        }
        //通过用户Id,得到该用户所有的评论信息
        pageBean=commentService.getAllCommentInfo(pageBean,uid);
        int pageNum=(int)Math.ceil(pageBean.getTotalCount()/5.0);
        request.setAttribute("pageNum",pageNum);
        //如果成功从数据库中读取数据，则进行跳转
        if(pageBean!=null&&pageBean.getList().size()>0){
            request.setAttribute("pageBean",pageBean);
            request.getRequestDispatcher("userjsp/userComment.jsp").forward(request,response);
        }else{
            request.setAttribute("pageBean",pageBean);
            System.out.println("无对应数据，请重新查询");
            request.getRequestDispatcher("userjsp/userComment.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    }
}
