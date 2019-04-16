<%@ page import="org.springframework.web.context.request.RequestScope" %>
<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2018/11/11
  Time: 11:26
  To change this template use File | Settings | File Templates.
--%>
<!DOCTYPE html>
<%@page contentType="text/html;charset=UTF-8" language="java" pageEncoding="UTF-8" %>
<html>
<head>
    <meta charset="UTF-8">
    <title>welcome</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/static/css/xin.css">
    <script src="${pageContext.request.contextPath}/static/js/dl.js"></script>
</head>
<body bgcolor="#fff0f5">

<div class="box">
    <div id="title"><h1 align="center">登录</h1></div>
    <form method="post" action="/login" onsubmit="return foLogin()">
        <p class="input_box">
            账户： <input id="userName" name="userName" type="text" placeholder="请输入您的账户">
        </p>
        <p class="input_box">
            密码： <input id="password" name="password" type="password" placeholder="请输入您的号码">
        </p>

        <div id="error_box"><br></div>
        <% if(request.getAttribute("errorMsg")!=null){%>
        <script>alert("${errorMsg}")</script>
        <%}%>
        <div class="button" align="center">
            <input type="submit" value="登录" >
        </div>
    </form>
    <h4 align="center"> <a href="${pageContext.request.contextPath}/jsp/zhuce.jsp">注册新用户</a></h4>
    <p align="center"> <a href="/visitorLogin" >以游客身份登录</a></p>
</div>
</body>
</html>