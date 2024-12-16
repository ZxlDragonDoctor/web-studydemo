package com.zxl.springmvcin.webspringmvcin.Filter;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.io.IOException;

public class LoginCheckFilter implements Filter {
    private static final String CONTENT_TYPE = "text/html; charset=UTF-8";
    private FilterConfig _filterConfig = null;
    private static final Log logger = LogFactory.getLog(LoginCheckFilter.class);
    private String excludedPages;
    private String[] excludedPageArray;

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        _filterConfig = filterConfig;
        excludedPages = filterConfig.getInitParameter("excludedPages");
        logger.info("excludedPages are:" + excludedPages);
        if (!excludedPages.isEmpty()) {
            excludedPageArray = excludedPages.split(",");
        }
    }
    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {
        System.out.println("执行过滤器LoginCheck");
        HttpServletRequest httpRequest = (HttpServletRequest) request;
        HttpServletResponse httpResponse = (HttpServletResponse) response;
        // 检查会话中是否有用户登录标识
        HttpSession session = httpRequest.getSession(false);
        boolean isExcludedPage = false;
        for (String page : excludedPageArray) {
            System.out.println(page);
            logger.info("URI is:" + httpRequest.getRequestURI()); // 判断是否在过滤url之外
            if (httpRequest.getRequestURI().contains(page)) {
                isExcludedPage = true;
            }
        }
        System.out.println(isExcludedPage);
        if (isExcludedPage) { // 在过滤url之外
            chain.doFilter(request, response);
        } else { // 不在过滤url之外, 判断登录
            if (session != null && session.getAttribute("user") != null) {
                // 用户已登录, 继续链路
                chain.doFilter(request, response);
            } else {
                // 用户未登录, 重定向到登录页面或返回未认证的错误信息
                httpResponse.sendRedirect("/zxl/login.jsp");
            }
        }
    }

    @Override
    public void destroy() {
        // 过滤器销毁代码
        logger.info("执行destory方法");
    }
}