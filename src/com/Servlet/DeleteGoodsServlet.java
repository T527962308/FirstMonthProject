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

public class DeleteGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        GoodsinfoDao goodsinfoDao = new GoodsinfoDao();
        try {
            if(id != null){
                int ID = Integer.parseInt(id);

                Goodsinfo goodsinfo = new Goodsinfo(ID);
                //返回得到结果
                int result = goodsinfoDao.removeGoods(goodsinfo);

                PrintWriter out = resp.getWriter();
                //判断结果是否大于1
                if(result > 0){
                    HttpSession httpSession = req.getSession();
                    httpSession.setAttribute("goodsinfo",goodsinfoDao.watchGoods());
                    out.println("<script type='text/javascript'>alert('删除成功');window.location.href='/HomePage.jsp';</script>");
                }else {
                    out.println("<script type='text/javascript'>alert('删除失败');window.location.href='/HomePage.jsp';</script>");
                }
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
