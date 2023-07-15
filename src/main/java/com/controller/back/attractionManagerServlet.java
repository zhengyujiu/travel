package com.controller.back;

import com.entity.Attraction;
import com.entity.PageBean;
import com.service.back.ServiceImpl.attractionServiceImpl;
import com.service.back.attractionService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(name = "attractionManagerServlet", value = "/attractionManagerServlet")
public class attractionManagerServlet extends HttpServlet {

    com.service.back.attractionService attractionService=new attractionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage=request.getParameter("currentPage");
        String pageSize=request.getParameter("pageSize");
        PageBean<Attraction> pageBean=new PageBean<>();
        //从前端传来的当前页和页的大小做判断，如果当前页为空，则设置当前页为1
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
        pageBean=attractionService.getAllAttractionInfo(pageBean);
        //注意，为了方便操作，将double类型强制转换为int类型
        int pageNum=(int)Math.ceil(pageBean.getTotalCount()/5.0);
        request.setAttribute("pageNum",pageNum);
        //如果成功从数据库中读取数据，则进行跳转
        if(pageBean!=null&&pageBean.getList().size()>0){
            request.setAttribute("pageBean",pageBean);
            request.getRequestDispatcher("backjsp/attractionManager.jsp").forward(request,response);
        }else{
            request.setAttribute("pageBean",pageBean);
            System.out.println("无对应数据，请重新查询");
            request.getRequestDispatcher("backjsp/attractionManager.jsp").forward(request,response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
