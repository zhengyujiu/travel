package com.controller.collection;

import com.entity.Collections;
import com.entity.Order;
import com.entity.PageBean;
import com.entity.User;
import com.service.CollectionService;
import com.service.OrderService;
import com.service.impl.CollectionServiceImpl;
import com.service.impl.OrderServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

@WebServlet("/oneUserCollectionList")
public class OneUserCollectionList extends HttpServlet {
    //这个类是无论用户是进行了条件搜索还是没有,只要点击了前一页和后一页和跳转页面,就跳转至此
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        CollectionService collectionService=new CollectionServiceImpl();
        User user = (User) req.getSession().getAttribute("user");
        Integer uid=user.getUid();
        List<Collections> collectionsList=collectionService.selectCollectionsByUid(uid);
        System.out.println(collectionsList);
        PageBean<Collections> pageBean=new PageBean<>();
            if (collectionsList==null||collectionsList.size()==0) {
                pageBean.setTotalCount(0);
                pageBean.setList(null);
                pageBean.setCurrentPage(1);
                pageBean.setPageSize(5);
                req.setAttribute("pageBean", pageBean);
                req.getRequestDispatcher("/userjsp/userCollection.jsp").forward(req, resp);
            }else {
                String pageSize = req.getParameter("pageSize") ;
                String currentPage =req.getParameter("currentPage") ;
                if (currentPage!=null){
                    pageBean.setCurrentPage(Integer.parseInt(currentPage));
                }else {
                    pageBean.setCurrentPage(1);
                }
                if (pageSize!=null){
                    pageBean.setPageSize(Integer.parseInt(pageSize));
                }else {
                    pageBean.setPageSize(5);
                }
                pageBean=collectionService.getCollectionByPage(collectionsList,pageBean);
                req.setAttribute("pageBean",pageBean);
                req.getRequestDispatcher("/userjsp/userCollection.jsp").forward(req,resp);
            }
        }
    }

