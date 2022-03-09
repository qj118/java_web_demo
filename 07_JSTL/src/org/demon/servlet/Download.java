package org.demon.servlet;

import org.apache.commons.io.IOUtils;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Base64;

public class Download extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        // 1. 设置下载的文件名
        String downloadFile = "a.jpg";
        ServletContext servletContext = request.getServletContext();
        // 2. 获取下载文件的类型
        String mimeType = servletContext.getMimeType("/file/" + downloadFile);
        // 3. 通过响应头告诉客户端返回的数据类型
        response.setContentType(mimeType);
        // 4. 通过响应头设置返回的数据用于下载，并设置下载后文件的名称（可以和原文件名不同）
        String agent = request.getHeader("User-Agent");
        String downloadName = new String();
        if(agent.contains("Firefox")) {
            downloadName = "attachment; fileName=" + "=?utf-8?B?"
                    + Base64.getEncoder().encodeToString("恶搞图片.jpg".getBytes("utf-8")) + "?=";
        }else{
            downloadName = "attachment; fileName=" + URLEncoder.encode("恶搞图片.jpg", "UTF-8");
        }
        response.setHeader("Content-Disposition", downloadName);

        // 5. 读取要下载的文件内容
        InputStream resourceAsStream = servletContext.getResourceAsStream("/file/" + downloadFile);
        // 6. 把下载的文件内容回传给客户端
        OutputStream outputStream = response.getOutputStream();
        IOUtils.copy(resourceAsStream, outputStream);
    }
}
