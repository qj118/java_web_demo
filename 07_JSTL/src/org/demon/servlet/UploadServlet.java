package org.demon.servlet;


import org.apache.commons.fileupload.FileItem;
import org.apache.commons.fileupload.FileItemFactory;
import org.apache.commons.fileupload.disk.DiskFileItemFactory;
import org.apache.commons.fileupload.servlet.ServletFileUpload;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.IOException;
import java.util.List;

public class UploadServlet extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        // 判断是否是多段数据
        if(ServletFileUpload.isMultipartContent(request)){
            // 创建 FileItemFactory 工厂实现类对象
            FileItemFactory fileItemFactory = new DiskFileItemFactory();
            // 创建用于解析上传数据的工具类对象
            ServletFileUpload servletFileUpload = new ServletFileUpload(fileItemFactory);
            // 得到表单项 list

            try {
                // 解析上传的数据，得到表单项 list
                List<FileItem> list = servletFileUpload.parseRequest(request);
                // 判断表单项是普通项还是上传项
                for(FileItem fileItem: list){
                    if(fileItem.isFormField())
                    {
                        System.out.println(fileItem.getFieldName() + " = " + fileItem.getString("UTF-8"));
                    }else{
                        // 保存上传文件
                        fileItem.write(new File("E:\\" + fileItem.getName()));
                        System.out.println(fileItem.getFieldName() + " " + fileItem.getName() + " to " + "E:\\");
                    }
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }
}
