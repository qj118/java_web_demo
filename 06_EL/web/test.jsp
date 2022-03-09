<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/5/12
  Time: 9:11
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Test</title>
</head>
<body>
    <!-- 将整个 request 对象放入 jsp 页面的 pageContext 域中 -->
    <% pageContext.setAttribute("req", request); %>
    协议：${ pageContext.request.scheme } <br/>
    服务器IP：${ pageContext.request.serverName } <br/>
    服务器端口：${ pageContext.request.serverPort } <br/>
    工程路径：${ pageContext.request.contextPath } <br/>
    请求方法：${ pageContext.request.method } <br/>
    客户端IP地址：${ pageContext.request.remoteHost } <br/>
    会话的id编号：${ pageContext.session.id } <br/>
</body>
</html>
