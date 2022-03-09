<%@ page import="org.demon.pojo.Student" %>
<%@ page import="java.util.List" %>
<%@ page import="java.util.ArrayList" %>
<%--
  Created by IntelliJ IDEA.
  User: demon
  Date: 2020/5/13
  Time: 8:08
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<html>
<head>
    <title>Test</title>
    <style type="text/css">
        table{
            border: 1px purple solid;
            width: 600px;
            border-collapse: collapse;
        }
        td, th{
            border: 1px purple solid;
        }
    </style>
</head>
<body>

    <%
        List<Student> students = new ArrayList<>();
        for(int i = 1;i <= 10; i++){
            students.add(new Student(i, "username_" + i, "password_" + i, 18, "phone_" + i));
        }
        request.setAttribute("stus", students);
    %>
    <table>
        <tr>
            <td>编号</td>
            <td>姓名</td>
            <td>密码</td>
            <td>年龄</td>
            <td>电话</td>
            <td>索引值</td>
        </tr>
        <%--
            items - 遍历集合
            var - 循环变量
            begin - 初始索引
            end - 结束索引
            step - 循环步长
            varStatus - 当前遍历到的数据的状态
        --%>
        <c:forEach items="${ requestScope.stus }" varStatus="status" var="stu">
            <tr>
                <td>${stu.id}</td>
                <td>${stu.username}</td>
                <td>${stu.password}</td>
                <td>${stu.age}</td>
                <td>${stu.phone}</td>
                <td>${status.index}</td>
            </tr>
        </c:forEach>
    </table>
</body>
</html>
