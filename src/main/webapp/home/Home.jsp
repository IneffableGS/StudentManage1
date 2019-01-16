<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/14
  Time: 20:40
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>管理中心</title>
</head>
<body>
<h3>欢迎您，<%=session.getAttribute("user")%></h3>
<h1>这里是管理中心</h1>
<ul>
    <li><a href="/home/courseQuery">课程管理</a></li>
    <li><a href="/home/studentQuery">学生管理</a></li>
    <li><a href="/home/scoreQuery">成绩管理</a></li>
    <%--<li><a href="#">查看成绩</a></li>--%>
    <li><a href="/home/reportQuery">成绩报告</a></li>
</ul>
</body>
</html>
