<%--
  Created by IntelliJ IDEA.
  User: PengRong
  Date: 2018/8/17
  Time: 11:51
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
    <title>测试@ModelAttribute---</title>
</head>
<body>
<p3>Model 和 ModelView 测试</p3>
<br/>
<%-- a 标签 href 属性， RequestMapping 注解 value 取值即可，记得 --%>
<a href="loginModel1">测试Model</a><br><br>
<a href="loginModel2">测试ModelMap</a><br><br>
<a href="loginModel3">测试ModelMapAndView</a><br><br>
</body>
</html>
