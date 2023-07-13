package com.controller.order;

import com.service.OrderService;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.HTML;
import java.io.IOException;

@WebServlet("/deleteOrderByOid")
public class deleteOrderByOid extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        int oid=Integer.parseInt(req.getParameter("deleteOid"));
        String searchName=req.getParameter("searchName");

        OrderService orderService=new OrderServiceImpl();
        int i = orderService.deleteOrderByOid(oid);
        String deleteMsg=null;
        if (i==1){
            deleteMsg="删除成功";
        }
        req.setAttribute("deleteMsg",deleteMsg);
        if (searchName==null||searchName.isEmpty()){
            req.getRequestDispatcher("queryOrderByPage").forward(req,resp);
        }
        else {
            req.getRequestDispatcher("searchOrderByUname?searchName="+searchName).forward(req,resp);
        }
    }
}
