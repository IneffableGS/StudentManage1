<%--
  Created by IntelliJ IDEA.
  User: dell
  Date: 2019/1/14
  Time: 21:44
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩录入</title>
</head>
<body>
<form method="post" action="/ScoreInput">
    <input name="cno" id="cno" type="text" placeholder="课程号" required autofocus />
    <input name="sno" id="sno" type="text" placeholder="学生学号" required />
    <input name="score" id="score" type="text" placeholder="学生成绩" required />

    <button type="submit" name="submit" value="确认"/>
</form>
</body>
</html>