<%@ page import="org.vincent.web.service.App" %>
<%@page contentType="text/html; charset=UTF-8" language="java" %>
<html>
<title>helloworld </title>
<body>
<% App app =new App(); %>
<% app.sayHello("vincent"); %>
<h2>Hello World! </h2>
</body>
</html>
