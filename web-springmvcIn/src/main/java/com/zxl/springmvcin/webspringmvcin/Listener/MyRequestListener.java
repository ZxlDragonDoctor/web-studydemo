package com.zxl.springmvcin.webspringmvcin.Listener;

import jakarta.servlet.ServletRequestEvent;
import jakarta.servlet.ServletRequestListener;
import jakarta.servlet.annotation.WebListener;
import jakarta.servlet.http.HttpServletRequest;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

@WebListener
public class MyRequestListener implements ServletRequestListener {
    private int count = 0;
    private static final Log logger = LogFactory.getLog(MyRequestListener.class);

    public void requestInitialized(ServletRequestEvent re) {
        HttpServletRequest request = (HttpServletRequest) re.getServletRequest();
        logger.info(request.getRequestURI());
        if (request.getRequestURI().endsWith("onlineCount.jsp")) {
            count++;
            re.getServletContext().setAttribute("count", count);
        }
    }

    public void requestDestroyed(ServletRequestEvent re) {
        // 可以在这里添加请求销毁时的逻辑处理
    }
}