package com.Servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.*;

public class DownloadFileServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //获取文件名
        String fileName = req.getParameter("fileName");
        //获取文件地址
        String fileUrl = req.getServletContext().getRealPath("/upload");
        //获取文件
        File file = new File(fileUrl,fileName);

        //判断文件是否存在
        if(file.exists()){
            //转换文件名为中文
            String fileName1 = new String(fileName.getBytes("utf-8"),"iso-8859-1");
            resp.setHeader("content-disposition","attachment;filename="+fileName1);

            //获得输入流和输出流
            InputStream is = new FileInputStream(file);

            OutputStream os = resp.getOutputStream();

            IOUtils.copy(is,os);
            //关闭资源
            is.close();
            os.close();

        }
    }
}
