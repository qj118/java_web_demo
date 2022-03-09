<%@ page import="java.util.Locale" %>
<%@ page import="java.util.ResourceBundle" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>国际化</title>
</head>
<body>
<%
    Locale locale = request.getLocale();
    ResourceBundle bundle = ResourceBundle.getBundle("i18n", locale);
%>
<form>
    <tr>
        <td><%=bundle.getString("username")%></td>
        <td><input name="username" type="text" /></td>
    </tr>
    <tr>
        <td><%=bundle.getString("password")%></td>
        <td><input type="password" /></td>
    </tr>
    <tr>
        <td colspan="2" align="center">
            <input type="reset" value="<%=bundle.getString("reset")%>" />
            <input type="submit" value="<%=bundle.getString("submit")%>" />
        </td>
    </tr>
</form>
</body>
</html>
