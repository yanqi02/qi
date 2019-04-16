<%@ page import="upcnews.bean.User" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2018/11/15
  Time: 18:43
  To change this template use File | Settings | File Templates.
--%>
<!doctype html>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>注册</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/xin.css">
    <script src="${pageContext.request.contextPath}/static/js/register.js"></script>
</head>
<body bgcolor="#fff0f5">
<% if(request.getAttribute("errorMsg")!=null){%>
<script>alert("${errorMsg}")</script>
<%}%>
<div class="box">
    <div id="title"><h1 align="center">注册</h1></div>
    <form method="post" action="/register" onsubmit="return foLogin()">
        <p class="input_box">
            账 &nbsp;&nbsp;户 ： <input id="userName" size="30px"  name="userName" type="text">
        </p>

        <p class="input_box">
            密  &nbsp;&nbsp;码 ： <input size="30px" id="password" name="password" type="password" >

            <br>
        <p class="input_box">
            确认密码:<input size="30px" id="password1" name="password1" type="password">
        </p>
        <div id="error_box"><br></div>
        <div class="button" align="center" >
            &nbsp;  &nbsp;<input type="submit" value="立即注册" >
            <% User user =new User("userName","password");%>
            <% user.toString();%>
            <% user.getUserName();%>
        </div>
    </form>
    <h4 align="center"> <a href="${pageContext.request.contextPath}/index.jsp">返回</a></h4>


</div>

</body>
</html>