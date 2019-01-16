<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/15
  Time: 10:27
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>课程管理</title>
</head>
<body>
<form action="/InquiryCourse">
    输入查询条件：
    <input type="text" sname="value" value=""><br>
    选择查询方式
    <select sname="col">
        <option value=""> 请选择 </option>
        <option value="cdate"> 学期 </option>
        <option value="cteacher">教师 </option>
        <option value="cno">课程号 </option>
        <option value="cname">课程名 </option>

    </select><br>
    <input type="submit" sname="submit" value=" 查询 ">
    <input type="button" sname="index" value=" 返回主页面 ">
</form>

</body>
</html>
