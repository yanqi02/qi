<%@ page import="upcnews.bean.Article" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: xiang
  Date: 2018/11/19
  Time: 21:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
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
                    <a href="homepage">首页</a>
                </li>
                <li class="dropdown pull-right">
                    <a class="dropdown-toggle" href="#" data-toggle="dropdown">下拉<strong class="caret"></strong></a>
                    <ul class="dropdown-menu">
                        <li>
                            <a href="homepage">返回</a>
                        </li>
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
        <div class="col-md-4 column">
            <h2>
                <%=article.getArticleName()%>
            </h2>
            <p>
                <%=article.getContext()%>
            </p>
            <form action="tongguo" method="post" name="tongguo">
                <input name="articleId" type="hidden" value="<%=article.getArticleId()%>">
                <input type="submit" value="批准" >
            </form>
            <%--<p>--%>
            <%--<a class="btn" href="#">View details »</a>--%>
            <%--</p>--%>
        </div>
        <%}%>
    </div>
</div>
</body>
</html>
