package com.controller.front;

import com.entity.Attraction;
import com.service.front.attractionService;
import com.service.front.frontImpl.attractionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@WebServlet(name = "homeServlet",value = "/homeServlet")
public class homeServlet extends HttpServlet {
    //在controller层导入要处理数据的service层接口
    attractionService attractionService=new attractionServiceImpl();
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        String username=request.getParameter("username");
        HttpSession httpSession=request.getSession();
        httpSession.setAttribute("uid","1");
        Object uid=httpSession.getAttribute("uid");
        if (uid==null) {
            request.setAttribute("IsLogin", 0);
        } else {
            request.setAttribute("IsLogin", 1);
            //向request域对象中设置属性
            request.setAttribute("uid", uid);
        }
        List<Attraction> attractionList = attractionService.getBeginSomeInfo();
        //将查询到的前10条景点数据放在request域变量中，用来前台主页面展示
        request.setAttribute("attractionList", attractionList);
        //创建变量attractionsByType存放不同景点类型的数据，展示到前端
        Map<String,List<Attraction>> attractionsByType=new HashMap<>();
        List<String> list=attractionService.getAllTypesInfo();
        for(String atype:list){
            List<Attraction> list1=attractionService.getAllInfoByType(atype);
            attractionsByType.put(atype,list1);
        }
        request.setAttribute("attractionsByType",attractionsByType);
        request.getRequestDispatcher("userjsp/userhome.jsp").forward(request,response);
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        super.doGet(request,response);
    }
}
