package com.example.javawebexptest.Servlet.chapter01;

import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name="documentServlet",value={"/generate-document"})
public class DocumentServlet extends HttpServlet {
    public void doGet(HttpServletRequest request,
                      HttpServletResponse response)
            throws ServletException, IOException {
        String doctype = request.getParameter("doctype");
        if(doctype.equals("word")){
            doctype = "application/msword;charset=gb2312";
            response.setContentType(doctype);
            response.setHeader("Content-Disposition",
                    "attachment;filename=data.doc");
        }else{
            doctype = "application/vnd.ms-excel;charset=gb2312";
            response.setContentType(doctype);
            response.setHeader("Content-Disposition", "attachment;filename=excel.xls");
        }
        // 设置完响应的内容类型，再返回输出流对象
        PrintWriter out = response.getWriter();
        out.println("学号\t姓名\t性别\t年龄\t所在系");
        out.println("95001\t李勇\t男\t20\t信息");
        out.println("95002\t刘晨\t女\t19\t数学");
    }
}

