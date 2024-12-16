package com.zxl.springmvcin.webspringmvcin.interceptor;

import com.zxl.springmvcin.webspringmvcin.pojo.User;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

public class LoginInterceptor implements HandlerInterceptor {
    private static final Log logger = LogFactory.getLog(LoginInterceptor.class);

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object o) throws Exception {
        logger.info("LoginInterceptor....preHandle");
        boolean flag = false;
        String uri = request.getRequestURI();
        if (uri.indexOf("/toIndex") > 0) {
            User user = (User) request.getSession().getAttribute("user");
            if (user == null) {
                // 用户没有登录
                logger.info("LoginInterceptor拦截请求...");
                request.setAttribute("message", "请先登录再访问首页!");
                request.getRequestDispatcher("/WEB-INF/jsp/login.jsp").forward(request, response);
            } else {
                logger.info("LoginInterceptor放行请求...");
                flag = true;
            }
        }
        return flag;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object o, ModelAndView modelAndView) throws Exception {
        logger.info("LoginInterceptor....postHandle");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object o, Exception e) throws Exception {
        logger.info("LoginInterceptor....afterCompletion");
    }
}