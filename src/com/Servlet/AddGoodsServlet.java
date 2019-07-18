package com.Servlet;



import com.Dao.GoodsinfoDao;
import com.Entity.Goodsinfo;
import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.FileUploadException;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;
import org.apache.commons.io.IOUtils;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.*;
import java.util.List;


public class AddGoodsServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doPost(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        PrintWriter out = resp.getWriter();
        try {
            Goodsinfo g = this.uploadFile(req,resp);

            if(g.getGoodsinfoName() == null || "".equals(g.getGoodsinfoName())){
                out.println("<script type='text/javascript'>alert('对不起，数据为空');history.back();</script>");
                throw new Exception("对不起，数据为空");
            }
            //保存进数据库
            GoodsinfoDao goodsinfoDao = new GoodsinfoDao();
            int result = goodsinfoDao.addGoods(g);
            if(result > 0){
                HttpSession httpSession = req.getSession();
                httpSession.setAttribute("goodsinfo",goodsinfoDao.watchGoods());
                out.println("<script type='text/javascript'>alert('上传成功');location.href='HomePage.jsp';</script>");
            }else {
                out.println("<script type='text/javascript'>alert('对不起，上传失败');history.back();</script>");
                throw new Exception("对不起，上传失败");
            }

        } catch (FileUploadException e) {
            e.printStackTrace();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 上传文件
     * @param req
     * @param resq
     * @return
     * @throws FileUploadException
     * @throws IOException
     */
    public Goodsinfo uploadFile(HttpServletRequest req, HttpServletResponse resq) throws FileUploadException, IOException{
        Goodsinfo goodsinfo = new Goodsinfo();
        // 判断当前表单是否为上传表单
        boolean a = ServletFileUpload.isMultipartContent(req);
        //判断表单是否是file
        if(a){
            //创建ServletFileUpload对象
            FileItemFactory factory = new DiskFileItemFactory();
            ServletFileUpload upload = new ServletFileUpload(factory);
            //获得表单
            List<FileItem> fileItemList = upload.parseRequest(req);
            //判断是否为空
            if(fileItemList != null && fileItemList.size() > 0){
                //循环遍历集合
                for(FileItem b : fileItemList){
                    //判断是普通表单还是上传表单
                    if(b.isFormField()){
                        //如果是普通表单
                        //price description stock
                        if("name".equals(b.getFieldName())){
                            goodsinfo.setGoodsinfoName(b.getString("utf-8"));
                        }else if("price".equals(b.getFieldName())){
                            try {
                                goodsinfo.setGoodsinfoPrice(Integer.parseInt(b.getString()));
                            }catch (Exception e){
                                e.printStackTrace();
                                PrintWriter out = resq.getWriter();
                                out.println("<script type= 'text/javascript'>alert('对不起，您的价格只能输入数字');history.back();</script>");
                            }
                        }else if("description".equals(b.getFieldName())){
                            goodsinfo.setGoodsinfoDescrip(b.getString("utf-8"));
                        }else if("stock".equals(b.getFieldName())){
                            try{
                                goodsinfo.setGoodsStock(Integer.parseInt(b.getString("utf-8")));
                            }catch (Exception e){
                                e.printStackTrace();
                                PrintWriter out = resq.getWriter();
                                out.println("<script type= 'text/javascript'>alert('对不起，您的数量只能输入价格');history.back();</script>");
                            }
                        }
                    }else {
                        //获得文件名
                        String name = b.getName();
                        //获得web工程在tomcat下的绝对路径
                        String parentPath = req.getServletContext().getRealPath("/upload");
                        //判断在文件下有没有这个文件夹
                        // parentFile.exists()：返回true表示目录存在
                        // parentFile.mkdirs()：用于创建目录
                        File parentFile = new File(parentPath);
                        if(!parentFile.exists()){
                            parentFile.mkdirs();
                        }
                        // 如果不报错，就将这个文件名设置到对象属性中
                        // 获得上传文件的文件对象
                        File newFile = new File(parentFile,name);

                        //输入流和输出流
                        InputStream inputStream = b.getInputStream();

                        OutputStream outputStream = new FileOutputStream(newFile);

                        //写入文件
                        IOUtils.copy(inputStream,outputStream);
                        //关闭流
                        inputStream.close();
                        outputStream.close();
                        //将文件名放入对象中
                        goodsinfo.setGoodsinfoPic(name);

                    }
                }
            }
        }
        return goodsinfo;
    }
}
