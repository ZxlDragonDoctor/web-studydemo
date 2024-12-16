package com.zxl.springmvcin.webspringmvcin.Listener;

import jakarta.servlet.*;
import jakarta.servlet.annotation.WebListener;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;
import javax.sql.DataSource;
import java.time.LocalTime;

@WebListener
public class MyContextListener implements ServletContextListener, ServletContextAttributeListener {
    private ServletContext context = null;
    private static final Log logger = LogFactory.getLog(MyContextListener.class);

    public void contextInitialized(ServletContextEvent sce) {
        Context ctx = null;
        DataSource dataSource = null;
        context = sce.getServletContext();
        try {
            if (ctx == null) {
                ctx = new InitialContext();
            }
            //JDNi数据源配置
            dataSource = (DataSource) ctx.lookup("java:comp/env/jdbc/elearningDS");
        } catch (NamingException ne) {
            logger.info("发生异常:" + ne);
        }
        context.setAttribute("dataSource", dataSource); // 添加属性
        logger.info("应用程序已启动:" + LocalTime.now());
    }

    public void contextDestroyed(ServletContextEvent sce) {
        context = sce.getServletContext();
        context.removeAttribute("dataSource");
        logger.info("应用程序已关闭:" + LocalTime.now());
    }

    public void attributeAdded(ServletContextAttributeEvent sce) {
        context = sce.getServletContext();
        logger.info("添加一个属性:" + sce.getName() + ":" + sce.getValue());
    }

    public void attributeRemoved(ServletContextAttributeEvent sce) {
        context = sce.getServletContext();
        logger.info("删除一个属性:" + sce.getName() + ":" + sce.getValue());
    }

    public void attributeReplaced(ServletContextAttributeEvent sce) {
        context = sce.getServletContext();
        logger.info("替换一个属性:" + sce.getName() + ":" + sce.getValue());
    }
}