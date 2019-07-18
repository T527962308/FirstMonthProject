<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2019/7/16
  Time: 23:10
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<html>
<head>
    <title>改变商品内容</title>
    <script type="text/javascript">
        function onResetImg() {
            var imgSpan = document.getElementById("imgSpan");
            imgSpan.innerHTML = '<input type="button" value="返回" onclick="onResetImg2()"/><input type="file" name="pic"> ';
        }
        function onResetImg2() {
            var imgSpan = document.getElementById("imgSpan");
            imgSpan.innerHTML = '<img src="upload/${g.getGoodsinfoPic()}" width="50px" height="50px" />\n' +
                '                        <input type="button" value="重新上传" onclick="onResetImg()"/>\n' +
                '                        <input type="hidden" name="pic" value="${g.getGoodsinfoPic()}" /> ';
        }
    </script>
</head>
<body>
<form  action="submissionGoodsServlet" method="post" enctype="multipart/form-data">
    <div style="color: red ;text-align:center">请输入修改信息表</div>
    <table align="center" border="1" wodth="0">
        <tr>
            <td>商品序号<input type="text" readonly="true" name="id" value="${g.getId()}"></td>
        </tr>
        <tr>
            <td>商品名字<input type="text" name="name" value="${g.getGoodsinfoName()}"></td>
        </tr>
        <tr>
            <td>
                商品图片
                <span id="imgSpan">
                    <c:if test="${g.getGoodsinfoPic()!=null}">
                        <img src="upload/${g.getGoodsinfoPic()}" width="50px" height="50px" />
                        <input type="button" value="重新上传" onclick="onResetImg()"/>
                        <input type="hidden" name="pic" value="${g.getGoodsinfoPic()}" />
                    </c:if>
                    <c:if test="${g.getGoodsinfoPic()==null}">
                        <input type="file" name="pic">
                    </c:if>
                </span>
            </td>
        </tr>
        <tr>
            <td>商品价格<input type="text" name="price" value="${g.getGoodsinfoPrice()}"></td>
        </tr>
        <tr>
            <td>商品简介<input type="text" name="description" value="${g.getGoodsinfoDescrip()}"></td>
        </tr>
        <tr>
            <td>商品库存<input type="text" name="stock" value="${g.getGoodsStock()}"></td>
        </tr>
        <tr align="center">
            <td >
                <input type="submit" value="提交" >
                <input type="button" value="返回" onclick="history.back()">
            </td>
        </tr>
    </table>
</form>
</body>
</html>
