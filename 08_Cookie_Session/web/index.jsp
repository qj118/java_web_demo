<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/5/14
  Time: 8:53
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
  <head>
    <title>Login</title>
  </head>
  <body>
  <form action="http://localhost:8080/08_Cookie_Session/login">
      用户名：<input type="text" name="username" value="${cookie.username.value}"/><br />
      密码：<input type="password" name="password" /> <br/>
      <input type="checkbox" name="remember">记住登录用户<br />
      <input type="submit" value="登录">
  </form>
  </body>
</html>
