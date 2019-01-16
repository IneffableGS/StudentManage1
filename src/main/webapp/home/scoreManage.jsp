<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: wangguanhua
  Date: 2019/1/16
  Time: 11:41 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程成绩管理</title>
</head>
<body>
<form method="post" action="/home/courseAdd">
    <%--cno,cname,cdate,cteacher--%>
    <input id="cname" name="cname" placeholder="课程名" />
    <select id="cdate" name="cdate">
        <option value="第一学期" selected>第一学期</option>
        <option value="第二学期">第二学期</option>
        <option value="第三学期">第三学期</option>
        <option value="第四学期">第四学期</option>
    </select>
    <input id="cteacher" name="cteacher" placeholder="任课教师" />
    <button type="submit" >新增课程</button>
</form>

<table>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>学生号</th>
        <th>学生名</th>
        <th>课程所属学期</th>
        <th>任课教师</th>
        <th>成绩</th>
        <th>操作</th>
    </tr>
    <%--展示--%>
    <tr>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
        <td></td>
    </tr>
    <%
        List courses = (LinkedList)session.getAttribute("courseList");

    %>
</table>
<ul style="display: inline-block; list-style: none">
    <li><a href="Home.jsp">返回首页</a></li>
</ul>
</body>
</html>
