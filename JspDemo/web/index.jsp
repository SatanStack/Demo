<%--
  Created by IntelliJ IDEA.
  User: satan
  Date: 2017/10/10
  Time: 下午12:36
  To change this template use File | Settings | File Templates.
--%>
<%@ page import="java.util.*" contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>First page</title>
  </head>
  <body>
  <h2>This is my first jsp page</h2>
  <ul>
    <li>current time:<%=new Date()%></li>
    <li>current server:<%=application.getServerInfo()%></li>
  </ul>
  </body>
</html>
