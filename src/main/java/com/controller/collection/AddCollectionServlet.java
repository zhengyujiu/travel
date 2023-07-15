package com.controller.collection;

import com.entity.Attraction;
import com.entity.Collections;
import com.entity.User;
import com.service.CollectionService;
import com.service.impl.CollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.time.LocalDate;

@WebServlet("/addCollectionServlet")
public class AddCollectionServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        User user= (User) req.getSession().getAttribute("user");
        Integer uid=user.getUid();
        Integer aid= null;
        Integer rcid=null;
        Integer hid=null;
        if (req.getParameter("aid")!=null){
            aid= Integer.valueOf(req.getParameter("aid"));
        }
        if (req.getParameter("rcid")!=null){
            rcid= Integer.valueOf(req.getParameter("rcid"));
        }
        if (req.getParameter("hid")!=null){
            rcid= Integer.valueOf(req.getParameter("hid"));
        }
        String cltime= String.valueOf(LocalDate.now());
            Collections collections=new Collections(null,aid,uid,rcid,hid,cltime);
            CollectionService collectionService=new CollectionServiceImpl();
            collectionService.addCollection(collections);
            String collectionMsg="收藏成功";
            req.setAttribute("collectionMsg",collectionMsg);
            req.getRequestDispatcher("homeServlet").forward(req,resp);
    }
}
