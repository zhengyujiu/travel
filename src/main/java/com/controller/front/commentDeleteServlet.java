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

@WebServlet(name = "commentDeleteServlet", value = "/commentDeleteServlet")
public class commentDeleteServlet extends HttpServlet {

    com.service.front.commentService commentService=new commentServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String cid=request.getParameter("cid");
        String currentPage=request.getParameter("currentPage");
        HttpSession httpSession=request.getSession();
        int uid=Integer.parseInt(httpSession.getAttribute("uid").toString());
        if(cid!=null){
            commentService.deleteOneByCid(cid);
        }else{
            System.out.println("无此条评论，请重新检查");
        }
        PageBean<Comment> pageBean=new PageBean();
        pageBean.setCurrentPage((Integer.parseInt(currentPage)));
        pageBean.setPageSize(5);
        //该条记录删除完之后，查询当前页面在该条记录删除完之后是否还有数据，如果没有数据则表示当前页为空，则返回到当前页的前一页
        pageBean=commentService.getAllCommentInfo(pageBean,uid);
        if(pageBean.getList().size()==0){
            currentPage=String.valueOf(Integer.parseInt(currentPage)-1);
        }
        request.getRequestDispatcher("myCommentServlet?currentPage="+currentPage).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
