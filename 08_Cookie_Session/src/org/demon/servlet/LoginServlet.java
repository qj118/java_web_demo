package org.demon.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class LoginServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        String username = request.getParameter("username");
        String password = request.getParameter("password");
        System.out.println(request.getParameter("remember"));

        if(username.equals("demon") && password.equals("123")){
            if(request.getParameter("remember") != null){
                Cookie cookie = new Cookie("username", username);
                cookie.setMaxAge(60*60*24*7); //Cookie 保留一周
                response.addCookie(cookie);
            }
            System.out.println("Login Success!");
            response.sendRedirect("http://localhost:8080/08_Cookie_Session/cookie.html");
        }else{
            System.out.println("Login Failed!");
            response.sendRedirect("http://localhost:8080/08_Cookie_Session");
        }
    }
}
