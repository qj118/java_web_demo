<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/5/13
  Time: 10:05
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Upload</title>
</head>
<body>
    <form action="/07_JSTL/uploadServlet" method="post" enctype="multipart/form-data">
        用户名：<input type="text" name="username">
        头像：<input type="file" name="upload">
        <input type="submit" value="上传"/>
    </form>
</body>
</html>
