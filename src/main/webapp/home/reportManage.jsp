<%@ page import="java.util.Map" %>
<%@ page import="java.util.HashMap" %><%--
  Created by IntelliJ IDEA.
  User: wangguanhua
  Date: 2019/1/16
  Time: 2:27 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>成绩报告</title>
</head>
<body>
<%
    Map<String, Integer> result = (HashMap<String, Integer>)session.getAttribute("result");
%>
<table style="text-align: center">
    <tr>
        <th colspan="2">总成绩报告单</th>
    </tr>
    <tr>
        <th>条目</th>
        <th>数量</th>
        <th>占比</th>
    </tr>
    <tr>
        <td>总数</td>
        <td><%=result.get("total")%></td>
        <td>-</td>
    </tr>
    <tr>
        <td><60</td>
        <td><%=result.get("bad")%></td>
        <td><%=result.get("bad")/(double)result.get("total")%></td>
    </tr>
    <tr>
        <td>60-70</td>
        <td><%=result.get("d")%></td>
        <td><%=result.get("d")/(double)result.get("total")%></td>
    </tr>
    <tr>
        <td>70-80</td>
        <td><%=result.get("c")%></td>
        <td><%=result.get("c")/(double)result.get("total")%></td>
    </tr>
    <tr>
        <td>80-90</td>
        <td><%=result.get("b")%></td>
        <td><%=result.get("b")/(double)result.get("total")%></td>
    </tr>
    <tr>
        <td>>90</td>
        <td><%=result.get("a")%></td>
        <td><%=result.get("a")/(double)result.get("total")%></td>
    </tr>
    <tr>
        <td>MAX</td>
        <td><%=result.get("max")%></td>
        <td>-</td>
    </tr>
    <tr>
        <td>MIN</td>
        <td><%=result.get("min")%></td>
        <td>-</td>
    </tr>
    <tr>
        <td>AVG</td>
        <td><%=result.get("avg")%></td>
        <td>-</td>
    </tr>


</table>
<ul style="display: inline-block; list-style: none">
    <li><a href="Home.jsp">返回首页</a></li>
</ul>
</body>
</html>
