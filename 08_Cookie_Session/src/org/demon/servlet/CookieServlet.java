package org.demon.servlet;

import org.demon.utils.CookieUtils;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class CookieServlet extends BaseServlet {

    protected void createCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie cookie = new Cookie("key", "value");
        response.addCookie(cookie);
        response.getWriter().write("Cookie 创建成功");
    }

    protected void getCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies){
            response.getWriter().write("Cookie[" + cookie.getName() + "] = " + cookie.getValue() + " <br/>");
        }
    }

    protected void updateCookie(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        //Cookie cookie = new Cookie("key", "newValue");
        Cookie cookie = CookieUtils.findCookie("key",request.getCookies());
        if( cookie != null )
        {
            cookie.setValue("new_value");
            response.addCookie(cookie);
            response.getWriter().write("Cookie[" + cookie.getName() +"]的值更新为 " + cookie.getValue());
        }
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie cookie = CookieUtils.findCookie("key", request.getCookies());
        if(cookie != null){
            cookie.setMaxAge(0);
            response.addCookie(cookie);
            response.getWriter().write("key Cookie is deleted!");
        }
    }

    protected void life3600(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie cookie = CookieUtils.findCookie("key", request.getCookies());
        if(cookie != null){
            cookie.setMaxAge(60*60);
            response.addCookie(cookie);
            response.getWriter().write("key Cookie duration is 3600s!");
        }
    }

    protected void testPath(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Cookie cookie  = new Cookie("testPath", "testPath");
        cookie.setPath(request.getContextPath() +"/abc");
        response.addCookie(cookie);
        response.getWriter().write("带过滤路径的cookie已创建！");
    }
}
