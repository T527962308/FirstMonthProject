<%--
  Created by IntelliJ IDEA.
  User: Tang
  Date: 2019/7/15
  Time: 19:18
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>注册界面</title>
    <script type="text/javascript">
        function GoBack(){
            window.location.href = "LogOn.jsp";
        }
    </script>
    <style type="text/css">
        .text{
            text-align:center
        }
    </style>
</head>
<body>
    <form action="registerServlet" method="post">
        <div style="color: red" align="center">${mus}</div>
        <div style="color: green; text-align:center" >账号注册页面</div>
        <table  border="1" align="center" >
            <tr >
                <td>请输入账号:<input type="text" name="username"></td>
            </tr>
            <tr >
                <td>请输入密码:<input type="password" name="password1"></td>
            </tr >
            <tr >
                <td>再次输入密码:<input type="password" name="password2"></td>
            </tr >
            <tr >
                <td>性别:
                    <select name="sex">
                        <option>男</option>
                        <option>女</option>
                    </select>
                </td>
            </tr>
            <tr>
                <td>
                    爱好:
                    <input type="checkbox" name="hobbys" value="游泳">游泳
                    <input type="checkbox" name="hobbys" value="看书">看书
                    <input type="checkbox" name="hobbys" value="敲代码">敲代码
                    <input type="checkbox" name="hobbys" value="玩左右手">玩左右手
                    <input type="checkbox" name="hobbys" value="游泳  ">游泳
                </td>
            </tr>
            <tr >
                <td>手机号码:<input type="text" name="phone"></td>
            </tr>
            <tr >
                <td>电子邮箱:<input type="text" name="email"></td>
            </tr>
            <tr>
                <td>地址:<input type="text" name="addrs"></td>
            </tr>
            <tr>
                <td style="text-align:center">
                    <input type="submit" value="注册">
                    <input type="button" value="返回" onclick="GoBack()">
                </td>
            </tr>
        </table>
    </form>
</body>
</html>
