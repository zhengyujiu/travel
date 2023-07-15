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

@WebServlet(name = "attractionDeleteServlet", value = "/attractionDeleteServlet")
public class attractionDeleteServlet extends HttpServlet {

    com.service.back.attractionService attractionService=new attractionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String currentPage=request.getParameter("currentPage");
        String aid=request.getParameter("aid");
        System.out.println(aid);
        if(aid!=null){
            attractionService.deleteOneByAid(aid);
        }else{
            System.out.println("无此用户，请重新选择");
        }
        PageBean<Attraction> pageBean=new PageBean();
        pageBean.setCurrentPage((Integer.parseInt(currentPage)));
        pageBean.setPageSize(5);
        //该条记录删除完之后，查询当前页面在该条记录删除完之后是否还有数据，如果没有数据则表示当前页为空，则返回到当前页的前一页
        pageBean=attractionService.getAllAttractionInfo(pageBean);
        if(pageBean.getList().size()==0){
            currentPage=String.valueOf(Integer.parseInt(currentPage)-1);
        }
        //从一个servlet请求转发到另一个servlet，如果需要传递数据，则使用拼接参数的方式，而不是将它放在一个域对象中，因为域对象不同
        request.getRequestDispatcher("attractionManagerServlet?currentPage="+currentPage).forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
