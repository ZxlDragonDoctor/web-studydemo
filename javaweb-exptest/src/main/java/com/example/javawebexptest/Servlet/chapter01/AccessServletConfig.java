package com.example.javawebexptest.Servlet.chapter01;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.annotation.WebInitParam;
import jakarta.servlet.annotation.WebServlet;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;


@WebServlet(name="accessServletConfig", value="/access-servletconfig", initParams={
        @WebInitParam(name="sname", value="Tom"),
        @WebInitParam(name="sage", value="19"),
        @WebInitParam(name="sgender", value="male")
})
public class AccessServletConfig extends HttpServlet {
    ServletConfig config = null;

    public void init(ServletConfig config) throws ServletException {
        super.init(config); // 必须调用超类的init()
        this.config = config;
    }

    public void doGet(HttpServletRequest request, HttpServletResponse response) throws IOException {
        response.setContentType("text/html");
        Enumeration<String> pns = config.getInitParameterNames();

        String sn = config.getServletName();
        ServletContext c = config.getServletContext();
        c.setAttribute("hello", "how are you");

        PrintWriter out = response.getWriter();
        out.println("<html><body>");

        while (pns.hasMoreElements()) {
            String p = (String) pns.nextElement();
            String v = config.getInitParameter(p);
            out.println("<h1>"+p + ":" + v + "</h1>");
        }

        out.println("<h1>"+sn + "</h1>");
        out.println("<h1>"+c + "</h1>");
        out.println(c.getAttribute("<h1>"+"hello" + "</h1>"));

        Enumeration<String> cpns = c.getInitParameterNames();
        while (cpns.hasMoreElements()) {
            String cp = (String) cpns.nextElement();
            String cv = c.getInitParameter(cp);
            out.println("<h1>"+cp + ":" + cv + "</h1>");
        }
        out.println("</body></html>");
    }
}