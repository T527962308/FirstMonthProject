<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2019/7/15
  Time: 15:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>登录页面</title>
    <script type="text/javascript">
        function register (){
            window.location.href = "Location.jsp";
        }
    </script>
    <style type="text/css">
        .text{
            text-align:center;
        }
    </style>
</head>
<body>
    <form action="logOnServlet" method="post">
        <table  border="0" width="0" align="center">
            <div style="color: red ;text-align:center">${mus}</div>
            <tr>
                <td>
                    <div class="text">登录页面</div>
                <td>
            </tr>
            <tr>
                <td>
                    <div class="text">
                        用户名：<input type="text" name="username">
                    </div>
                </td>
            </tr>
            <tr>
                <td>
                    <div class="text">
                        密码： &nbsp; <input type="text" name="password">
                    </div>
                </td>
            </tr>
            <tr>
                <td class="text">
                    <input type="submit" value="登录">
                    <input type="button" value="注册" onclick="register()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
