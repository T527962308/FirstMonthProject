package com.Servlet;

import com.Dao.GoodsinfoDao;
import com.Dao.UserDao;
import com.Entity.Goodsinfo;
import com.Entity.User;
import com.mysql.cj.Session;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LogOnServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userName = req.getParameter("username");
        String password = req.getParameter("password");
        try{
            if("".equals(userName) && "".equals(password)){
                req.setAttribute("mus","对不起，账号或密码不能为空");
                req.getRequestDispatcher("LogOn.jsp").forward(req,resp);
            }
            UserDao userDao = new UserDao();
            User u = userDao.Verification(userName,password);
            if(u != null){
                //获取对象信息
                resp.sendRedirect("/homePageServlet");
            }else {
                req.setAttribute("mus","对不起，您的账号或者密码错误");
                req.getRequestDispatcher("LogOn.jsp").forward(req,resp);
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
