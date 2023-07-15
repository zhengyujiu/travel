package com.controller.front;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "produceOrderServlet", value = "/produceOrderServlet")
public class produceOrderServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession httpSession = request.getSession();
        String chooseAttraction = (String) httpSession.getAttribute("chooseAttraction");
        //注意：在项目中至少选择景点，如果未选择景点，但选择了其他，仍然无法生成订单!
        //如果选择景点为空，则表示未选择，需要重新进行arriveServlet进行景点选择
        if (chooseAttraction == null) {
            request.getRequestDispatcher("arriveServlet").forward(request, response);
        } else {
            System.out.println(httpSession.getAttribute("aname"));
            System.out.println(httpSession.getAttribute("aprice"));
            System.out.println(httpSession.getAttribute("hname"));
            System.out.println(httpSession.getAttribute("rcname"));
            System.out.println(httpSession.getAttribute("chooseRoom"));
            System.out.println(httpSession.getAttribute("rtype"));
            System.out.println(httpSession.getAttribute("rprice"));
            //如果景点已选，则已达到生成订单的基本要求，生成订单
            request.getRequestDispatcher("orderForm.jsp").forward(request, response);
        }
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
