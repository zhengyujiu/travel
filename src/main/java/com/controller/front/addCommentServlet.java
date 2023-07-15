package com.controller.front;

import com.entity.Comment;
import com.service.front.frontImpl.commentServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

@WebServlet(name = "addCommentServlet", value = "/addCommentServlet")
public class addCommentServlet extends HttpServlet {

    com.service.front.commentService commentService=new commentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        HttpSession httpSession=request.getSession();
        int uid=Integer.parseInt(httpSession.getAttribute("uid").toString());
        String aid=request.getParameter("aid");
        String ccontent=request.getParameter("ccontent");
        String uscore=request.getParameter("uscore");
        Date cdate = new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("YYYY-MM-dd");
        System.out.println(aid+" "+uid+" "+ccontent+" "+uscore);
        Comment comment=new Comment();
        comment.setAid(Integer.parseInt(aid));
        comment.setCcontent(ccontent);
        comment.setCdate(simpleDateFormat.format(cdate));
        comment.setUid(uid);
        comment.setUscore(Integer.parseInt(uscore));
        commentService.insertOneComment(comment);
        String insertResult=null;
        if(comment.getCid()!=0){
            insertResult="yes";
        }else{
            insertResult="no";
        }
        //注意，这里从一个servlet到另一个servlet，使用重定向的方式，而非请求转发。经测试，请求转发不到arriveServlet中!
        response.sendRedirect("arriveServlet?insertResult="+insertResult);
//        request.getRequestDispatcher("arriveServlet?insertResult="+insertResult).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
