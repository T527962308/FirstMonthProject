package com.Servlet;

import com.Dao.GoodsinfoDao;
import com.Entity.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class HomePageServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        GoodsinfoDao goodsinfoDao = new GoodsinfoDao();

        List list = goodsinfoDao.watchGoods();

        req.setAttribute("goodsinfo",list);

        req.getRequestDispatcher("HomePage.jsp").forward(req,resp);
    }
}
