package org.demon.servlet;

import com.google.gson.Gson;
import org.demon.pojo.Person;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AjaxServlet extends BaseServlet {

    protected void javaScriptAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("收到 AJAX 请求");
        Person person = new Person(7, "毛球");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        response.getWriter().write(personJsonString);
    }

    protected void jQueryAjax(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException{
        System.out.println("收到 jQuery AJAX 请求");
        Person person = new Person(7, "毛球");
        Gson gson = new Gson();
        String personJsonString = gson.toJson(person);
        response.getWriter().write(personJsonString);
    }
}
