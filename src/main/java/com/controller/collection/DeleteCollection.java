package com.controller.collection;

import com.service.CollectionService;
import com.service.impl.CollectionServiceImpl;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Service;
import java.io.IOException;

@WebServlet("/deleteCollection")
public class DeleteCollection extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer clid = Integer.valueOf(req.getParameter("clid"));
        CollectionService collectionService=new CollectionServiceImpl();
        collectionService.deleteCollectionByClid(clid);
        req.getRequestDispatcher("oneUserCollectionList").forward(req,resp);
    }
}
