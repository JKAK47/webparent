<!-- The Page loading <%= (new java.util.Date()).toString() %> -->          <!-- 會顯示在客戶端網頁上 -->
<%-- The Page loading <%= (new java.util.Date()).toString() %> --%>         <!-- jsp 編譯為servlet 時候將去除這個注釋 -->
<%-- 有三種指令

 page :设置页面内部的多个属性来配置整个jsp页面属性；
  pageEncoding 表示jsp頁面編碼屬性, contentType 表示jsp文档类型，language 表示jsp页面将插入的代码类型，import 引入的java代码包(只有这个属性可以重复设置)
 include 在当前jsp 文档中引用新的文档流。
 taglib

 --%>
<%-- jsp 指令元素命令 --%>
<%@ page contentType="text/html;charset=UTF-8" language="java" pageEncoding="utf-8"
    import="java.util.*"
%>

<!--
webapp/pages/index.jsp
-->

<html>
<head>
    <title>helloworld </title>
</head>

<body>
    <%-- JSP 指令元素 include 指令  --%>
    <%--<jsp:include page="child.jsp"/>--%>
    <%@ include file="child.jsp"%>
    <p3>主机地址：</p3>
    <%-- jsp 表达式，只能写一行表达式 --%>
    <%=
    request.getRemoteHost()

    %>
    <%-- JSP 表达式 XML 形式 --%>
    <jsp:expression>
        request.getRemoteHost()
    </jsp:expression>

    <%--
        JSP 小脚本，即可以写入多行java 代码，java代码块
     --%>
    <%
        Date date=new Date();
        out.print("Current Data : "+ date);
    %>
    <% if(Math.random() < 0.5) {  int count=0; %>
        <p4>Hava a <B>nice</B> day.</p4>
    <% } else  { %>
        <p4>Have a <B>lousy</B> day.</p4>
    <% } %>

    <%-- JSP 声明
        可以定义变量和方法，并通过JSP表达式调用方法，输出方法执行结果。
     --%>
    <%!
        String color[]={"red","blue","green"};
        public  String getColor(int i){
        		return  color[i];
        }
    %>
    <%-- JSP表达式 调用函数并输出结果 --%>
    <%=
    getColor((int) Math.floor(Math.random()*3))
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
