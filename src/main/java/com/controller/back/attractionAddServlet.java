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

@WebServlet(name = "attractionAddServlet", value = "/attractionAddServlet")
public class attractionAddServlet extends HttpServlet {

    com.service.back.attractionService attractionService=new attractionServiceImpl();

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        request.setCharacterEncoding("UTF-8");
        //注意：为了和修改用户信息模态框做区分，每一个用户参数后面拼接字符串1
        String aname1=request.getParameter("aname1");
        String aaddress1=request.getParameter("aaddress1");
        String adescription1=request.getParameter("adescription1");
        String atype1=request.getParameter("atype1");
        String acity1=request.getParameter("acity1");
        String apicture1=request.getParameter("apicture1");
        Float ascore1=Float.parseFloat(request.getParameter("ascore1"));
        Float aprice1=Float.parseFloat(request.getParameter("aprice1"));
        Attraction attraction=new Attraction();
        attraction.setAname(aname1);
        attraction.setAaddress(aaddress1);
        attraction.setAdescription(adescription1);
        attraction.setAtype(atype1);
        attraction.setAscore(ascore1);
        attraction.setAprice(aprice1);
        attraction.setAcity(acity1);
        attraction.setApicture(apicture1);

        //会将通过自动递增生成的主键封装到user中返回，无需返回值
        attractionService.insertOneAttraction(attraction);
        int count=attractionService.getAllCount();
        //因为double类型数据有小数点，所以先将double类型转化为int类型，再将其转换为字符串类型传参
        String currentPage=String.valueOf((int)Math.ceil(count/5.0));
        //传入新的当前页，这样在新增数据之后，会直接在最后一页中看到新增的数据
        request.getRequestDispatcher("attractionManagerServlet?currentPage="+currentPage).forward(request,response);
    }

    //注意新增用户表单提交使用的是post方法，注意要在doPost中调用doGet方法
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request,response);
    }
}
