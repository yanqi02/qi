<%@ page import="upcnews.bean.Article" %>
<%@ page import="upcnews.bean.Authority" %>
<%@ page import="upcnews.bean.User" %>
<%@ page import="java.util.List" %>
<%@ page import="sss.*" %>
<%@ taglib prefix="c" uri="http://www.springframework.org/tags/form" %>
<%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2018/11/15
  Time: 19:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>新闻系统</title>
    <!-- 新 Bootstrap 核心 CSS 文件 -->
    <link href="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet">

    <!-- jQuery文件。务必在bootstrap.min.js 之前引入 -->
    <script src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>

    <!-- 最新的 Bootstrap 核心 JavaScript 文件 -->
    <script src="https://cdn.staticfile.org/twitter-bootstrap/3.3.7/js/bootstrap.min.js"></script>
</head>
<body>
<% if(request.getAttribute("errorMsg")!=null){%>
<script>alert("${errorMsg}")</script>
<%}%>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-12 column">
            <ul class="nav nav-tabs">
                <li class="active">
                    <a href="#">首页</a>
                </li>
                <li class="dropdown pull-right">
                    <a class="dropdown-toggle" href="#" data-toggle="dropdown">菜单<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="/write">写新闻</a>
                        </li>
                        <%if(((User)session.getAttribute("user")).getAuthority()==Authority.administrator){%>
                        <li>
                            <a href="/approve">审核</a>
                        </li>
                        <%}%>
                        <li class="divider">
                        </li>

                    </ul>
                </li>
            </ul>
        </div>
    </div>
    <div class="row clearfix">
        <% List<Article> articles= (List<Article>) request.getAttribute("articles");%>
        <% for(Article article:articles){ %>
        <br>
        <div>
            <ul>
                <li><h1>
                    <%=article.getArticleName()%><br>
                    <h2>新闻</h2>
                    <%=article.tran(article.getArticleName())%>
                </h1>
                    <p>
                        <%=article.getContext()%>
                    </p></li>
            </ul>
            <%--<p>--%>
            <%--<a class="btn" href="#">View details »</a>--%>
            <%--</p>--%>
        </div>
        <%}%>
    </div>
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <ul class="pagination">

            </ul>
        </div>
    </div>
</div>
</body>
</html>
