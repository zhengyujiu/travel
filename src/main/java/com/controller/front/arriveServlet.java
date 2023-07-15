package com.controller.front;

import com.entity.Attraction;
import com.service.front.attractionService;
import com.service.front.frontImpl.attractionServiceImpl;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.annotation.*;
import java.io.IOException;
import java.util.List;

@WebServlet(name="arriveServlet",value="/arriveServlet")
public class arriveServlet extends HttpServlet {
    //使用attractionService用于执行所有对景点的操作
    attractionService attractionService=new attractionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String QueryCity=request.getParameter("QueryCity");
        String insertResult=request.getParameter("insertResult");
        System.out.println(1);
        if(insertResult!=null){
            request.setAttribute("insertResult",insertResult);
        }
        List<Attraction> attractionList;
        if(QueryCity==null){
            attractionList=attractionService.getBeginSomeInfo();
        }else{
            attractionList=attractionService.getSomeByQueryCity(QueryCity);
        }
        HttpSession httpSession=request.getSession();
        String uid=httpSession.getAttribute("uid").toString();
        if ("".equals(uid)) {
            request.setAttribute("IsLogin", 0);
        } else {
            request.setAttribute("IsLogin", 1);
        }
        request.setAttribute("attractionList",attractionList);
        request.getRequestDispatcher("userjsp/userArrive.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
