<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2019/7/16
  Time: 15:54
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
</head>
<body>
    <form action="addGoodsServlet" method="post" enctype="multipart/form-data">
        <div style="color: red ;text-align:center">请输入添加信息表</div>
        <table align="center" border="1" wodth="0">
            <tr>
                <td>商品名字<input type="text" name="name"></td>
            </tr>
            <tr>
                <td>
                    商品图片
                    <img src="" width="50px" height="50px" />
                    <input type="file" name="pic" value="">
                </td>
            </tr>
            <tr>
                <td>商品价格<input type="text" name="price" ></td>
            </tr>
            <tr>
                <td>商品简介<input type="text" name="description"></td>
            </tr>
            <tr>
                <td>商品库存<input type="text" name="stock" ></td>
            </tr>
            <tr align="center">
                <td >
                    <input type="submit" value="提交">
                    <input type="button" value="返回" onclick="history.back()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
