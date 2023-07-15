package com.controller.back;

import com.entity.Attraction;
import com.service.back.ServiceImpl.attractionServiceImpl;
import com.service.back.attractionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "attractionReviseServlet", value = "/attractionReviseServlet")
public class attractionReviseServlet extends HttpServlet {

    com.service.back.attractionService attractionService=new attractionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        String currentPage=request.getParameter("currentPage");
        String aname=request.getParameter("aname");
        String aaddress=request.getParameter("aaddress");
        String adescription=request.getParameter("adescription");
        String atype=request.getParameter("atype");
        String acity=request.getParameter("acity");
        String apicture=request.getParameter("apicture");
        Float ascore=Float.parseFloat(request.getParameter("ascore"));
        Float aprice=Float.parseFloat(request.getParameter("aprice"));
        String aid=request.getParameter("aid");
        System.out.println(aid);
        Attraction attraction=new Attraction();
        attraction.setAid(Integer.parseInt(aid));
        attraction.setAname(aname);
        attraction.setAaddress(aaddress);
        attraction.setAdescription(adescription);
        attraction.setAtype(atype);
        attraction.setAscore(ascore);
        attraction.setAprice(aprice);
        attraction.setAcity(acity);
        attraction.setApicture(apicture);
        attractionService.updateOneByAttraction(attraction);
        request.getRequestDispatcher("attractionManagerServlet?currentPage="+currentPage).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
