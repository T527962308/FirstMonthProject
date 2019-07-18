package com.Servlet;

import com.Dao.UserDao;
import com.Entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;

public class RegisterServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String username = req.getParameter("username");
        String passwrod1 = req.getParameter("password1");
        String password2 = req.getParameter("password2");
        String sex = req.getParameter("sex");
        String [] hobbys = req.getParameterValues("hobbys");  //兴趣
        String phone = req.getParameter("phone");
        String email = req.getParameter("email");
        String addrs = req.getParameter("addrs");  //地址

        //判断是否为空
        PrintWriter out = resp.getWriter();
        if(username==null || passwrod1==null|| password2==null||sex==null||
                hobbys==null||phone==null||email==null || addrs == null){
            out.println("<script type='text/javascript'>alert('需要全部填写');history.back();</script>");
        }


        //将数组转换成  String
        StringBuffer hobbys1 = new StringBuffer();
        if(hobbys != null){
            for(String a: hobbys){
                hobbys1.append(a+",");
            }
        }

        String hobbys2 = hobbys1.toString();

        //将sex转换成int
        int sex2 = 0;
        if(sex.equals("男")){
            sex2 = 1;
        }else {
            sex2 = 2;
        }

        //判断两次密码是否一致
        try {
            if(!(passwrod1.equals(password2))){
//            req.setAttribute("mus","对不起，您两次账号密码不一致");
//            req.getRequestDispatcher("Location.jsp").forward(req,resp);
                out.println("<script type='text/javascript'>alert('对不起，您两次账号密码不一致');history.back();</script>");
                throw new Exception();
            }
//        判断邮箱是否一致
            char [] emailChar = email.toCharArray();
            if(emailChar[0]=='.' || emailChar[emailChar.length-1]== '.' || email.indexOf("@") == -1){
                req.setAttribute("mus","对不起，邮箱格式错误");
                req.getRequestDispatcher("Location.jsp").forward(req,resp);
                throw new Exception();
            }
            UserDao userDao = new UserDao();
            User user = userDao.register(username, passwrod1, sex2,hobbys2,phone, email,addrs);


            //判断是否写入数据库
            if(user != null){
                HttpSession session = req.getSession();
//            PrintWriter out = resp.getWriter();
                session.setAttribute("username",user);
                out.println("<script type='text/javascript'>alert('注册成功');window.location.href='/LogOn.jsp';</script>");
                throw new Exception();
            }else {
                req.setAttribute("mus","对不起，注册失败，请重试");
                req.getRequestDispatcher("Location.jsp").forward(req,resp);
            }
        }catch (Exception e){
            e.printStackTrace();
        }

    }
}
