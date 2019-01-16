<%@ page import="project.obj.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: wangguanhua
  Date: 2019/1/16
  Time: 11:12 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>学生管理</title>
</head>
<body>

<form method="post" action="/home/studentAdd">
    <%--cno,cname,cdate,cteacher--%>
    <input id="sname" name="sname" placeholder="学生姓名" />
    <button type="submit" >新增学生</button>
</form>

<table>
    <tr>
        <th>学号</th>
        <th>姓名</th>
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
        List<Student> students = (LinkedList<Student>)session.getAttribute("studentList");
        for (Student s:students) {
    %>
    <tr>
        <td><%=s.getSno()%></td>
        <td><%=s.getName()%></td>
        <td><a href="/home/studentDelete?sno=<%=s.getSno()%>">删除</a></td>
    </tr>
    <%
        }
    %>
</table>
<ul style="display: inline-block; list-style: none">
    <li><a href="Home.jsp">返回首页</a></li>
</ul>

</body>
</html>
