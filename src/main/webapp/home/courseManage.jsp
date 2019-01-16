<%@ page import="java.util.List" %>
<%@ page import="project.obj.Course" %>
<%@ page import="java.util.LinkedList" %><%--
  Created by IntelliJ IDEA.
  User: wangguanhua
  Date: 2019/1/16
  Time: 8:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
</head>
<body>
<form method="post" action="/home/courseAdd">
    <%--cno,cname,cdate,cteacher--%>
    <input id="cname" sname="cname" placeholder="课程名" />
    <select id="cdate" sname="cdate">
        <option value="第一学期" selected>第一学期</option>
        <option value="第二学期">第二学期</option>
        <option value="第三学期">第三学期</option>
        <option value="第四学期">第四学期</option>
    </select>
    <input id="cteacher" sname="cteacher" placeholder="任课教师" />
    <button type="submit" >新增课程</button>
</form>

<table>
    <tr>
        <th>课程号</th>
        <th>课程名</th>
        <th>课程所属学期</th>
        <th>任课教师</th>
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
        List<Course> courses = (LinkedList<Course>)session.getAttribute("courseList");
        for (Course c:courses) {
            %>
            <tr>
                <td><%=c.getCno()%></td>
                <td><%=c.getCname()%></td>
                <td><%=c.getCdate()%></td>
                <td><%=c.getCteacher()%></td>
                <td><a href="/home/courseDelete?cno=<%=c.getCno()%>">删除</a></td>
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
