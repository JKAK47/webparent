<!-- The Page loading <%= (new java.util.Date()).toString() %> -->          <!-- 會顯示在客戶端網頁上 -->
<%-- The Page loading <%= (new java.util.Date()).toString() %> --%>         <!-- jsp 編譯為servlet 時候將去除這個注釋 -->
<%-- 有三種指令

 page :设置页面内部的多个属性来配置整个jsp页面属性；
  pageEncoding 表示jsp頁面編碼屬性, contentType 表示jsp文档类型，language 表示jsp页面将插入的代码类型，import 引入的java代码包(只有这个属性可以重复设置)
 include 在当前jsp 文档中引用新的文档流。
 taglib

 --%>

<%@ page contentType="text/html; charset=UTF-8" language="java" pageEncoding="utf-8"
    import="java.util.*"
%>

<html>
<head>
    <title>helloworld </title>
</head>

<body>
    <jsp:include page="child.jsp"/>
    <%
        Date date=new Date();
        out.print("Current Data : "+ date);
    %>
    <h2>Hello World! Web. </h2>
    <h3>JSP页面组成 JSP2.2 Spec</h3>
    <table>
       <tr>
           <td>HTML标记</td>
       </tr>
        <tr>
            <td>JSP标签</td>
        </tr>
        <tr> <td>JAVA程序片段</td></tr>
    </table>
    <h4>JSP 指令元素，設定jsp網頁相關屬性 </h4>
</body>
</html>
