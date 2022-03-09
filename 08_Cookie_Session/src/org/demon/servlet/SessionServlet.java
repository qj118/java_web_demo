package org.demon.servlet;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class SessionServlet extends BaseServlet {
    protected void getSession(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        HttpSession session = request.getSession();
        if(session.isNew())
        {
            response.getWriter().write( "Session " + session.getId() + " is created!");
        }else{
            response.getWriter().write("Get session " + session.getId());
        }
    }

    protected  void setAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        request.getSession().setAttribute("key", "value");
        response.getWriter().write("在 Session 保存了数据。");
    }

    protected void getAttribute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        Object obj = request.getSession().getAttribute("key");
        response.getWriter().write("获取 Session 域中的数据 key = " + obj);
    }

    protected void getLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        int maxInactiveInterval = request.getSession().getMaxInactiveInterval();
        System.out.println(maxInactiveInterval);
        response.getWriter().write("Session 的默认超时时长为：" + maxInactiveInterval + "秒");
    }

    protected void setLife(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.getSession().setMaxInactiveInterval(3);
        response.getWriter().write("Session 的默认超时时长为：3秒");
    }

    protected void deleteNow(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{

        request.getSession().invalidate();
        response.getWriter().write("Session 已无效！");
    }
}
