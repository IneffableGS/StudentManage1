<%@ page import="java.util.List" %>
<%@ page import="java.util.LinkedList" %>
<%@ page import="project.obj.Student" %>
<%@ page import="project.obj.Course" %>
<%@ page import="project.obj.Score" %><%--
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
<%
    LinkedList<Student> students = (LinkedList<Student>) session.getAttribute("students");
    LinkedList<Course> courses = (LinkedList<Course>) session.getAttribute("courses");
    LinkedList<Score> scores = (LinkedList<Score>) session.getAttribute("scores");
%>
<form method="post" action="/home/scoreAdd">
    <%--cno,cname,cdate,cteacher--%>

    <br>
    <select id="sno" name="sno">
        <%
            for (Student s : students) {
        %>
        <option value="<%=s.getSno()%>"><%=s.getName() + " " + s.getSno()%>
        </option>
        <%
            }
        %>
    </select>
    <select id="cno" name="cno">
        <%
            for (Course c : courses) {
        %>
        <option value="<%=c.getCno()%>"><%=c.getCname() + " " + c.getCno()%>
        </option>
        <%
            }
        %>
    </select>
    <br>
    <input id="cteacher" name="score" placeholder="成绩" type="number" value="60"/>
    <br>
    <button type="submit">录入成绩</button>
</form>

<table>
    <tr>
        <th>学生号</th>
        <th>学生名</th>
        <th>课程号</th>
        <th>课程名</th>
        <th>课程所属学期</th>
        <th>任课教师</th>
        <th>成绩</th>
        <th>操作</th>
    </tr>
    <%--展示--%>
    <%
        for (Score s : scores) {
    %>
    <tr>
        <td><%=s.getSno()%></td>
        <td><%=s.getSname()%></td>
        <td><%=s.getCno()%></td>
        <td><%=s.getCname()%></td>
        <td><%=s.getCdate()%></td>
        <td><%=s.getCteacher()%></td>
        <td><%=s.getScore()%></td>
        <td><a href="/home/scoreDelete?sno=<%=s.getSno()%>&cno=<%=s.getCno()%>">删除</a></td>
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
