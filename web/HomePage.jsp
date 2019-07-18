<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2019/7/15
  Time: 19:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript">
        function add() {
            window.location.href ="AddGoods.jsp";
        }
        function remove(id) {
            window.location.href ="deleteGoodsServlet?id="+id;
        }
        function revise(id) {
            window.location.href ="changeGoodsServler?id="+id;
        }
    </script>
</head>
<body>
    <form action="homePageServlet" method="post">
        <div style="color: orangered ;text-align: center">物品信息栏</div>
        <table align="center" border="1" width="0">
            <thead align="center">
                <tr>
                    <td>商品序号</td>
                    <td>商品名字</td>
                    <td>商品图片</td>
                    <td>商品价格</td>
                    <td>商品简介</td>
                    <td>商品库存</td>
                    <td>状态值</td>
                    <td>操作</td>
                </tr>
            </thead>
            <tbody>
                <c:forEach items="${goodsinfo}" var="goods" varStatus="s">
                    <tr>
                        <td>${goods.id}</td>
                        <td>${goods.goodsinfoName}</td>
                        <td>
                            <a href="downloadFileServlet?fileName=${goods.goodsinfoPic}">
                                <img src="upload/${goods.goodsinfoPic}" width="50px" height="50px" />
                            </a>
                        </td>
                        <td>${goods.goodsinfoPrice}</td>
                        <td>${goods.goodsinfoDescrip}</td>
                        <td>${goods.goodsStock}</td>
                        <td>${goods.flas}</td>
                        <td>
                            <input type="button" value="修改" onclick="revise(${goods.id})">
                            <input type="button" value="删除" onclick="remove(${goods.id})">
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
            <tfoot align="center">
                <tr>
                    <td colspan="8"><input type="button" value="添加" onclick="add()"></td>
                </tr>
            </tfoot>
        </table>
    </form>
</body>
</html>
