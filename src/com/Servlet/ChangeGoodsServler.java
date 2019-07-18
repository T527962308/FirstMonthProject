package com.Servlet;

import com.Dao.GoodsinfoDao;
import com.Entity.Goodsinfo;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class ChangeGoodsServler extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.setCharacterEncoding("utf-8");
        resp.setContentType("text/html;charset=utf-8");

        String id = req.getParameter("id");

        try {
            if(id == null || "".equals(id)){
                throw new Exception();
            }
            GoodsinfoDao goodsinfoDao = new GoodsinfoDao();

            Goodsinfo goodsinfo = goodsinfoDao.fantGoodsbyID(id);
            String name = goodsinfo.getGoodsinfoName();
            if(goodsinfo != null){

                HttpSession session = req.getSession();
                session.setAttribute("g",goodsinfo);
                resp.sendRedirect("ChangeGoods.jsp");
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
