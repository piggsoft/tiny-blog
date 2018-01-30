package com.piggsoft.tinyblog.interceptor;

import com.piggsoft.tinyblog.service.IAdminKit;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @author piggsoft
 * @version 1.0
 * @create 2018/1/30
 * @since 1.0
 */
@Component
public class AdminInterceptor implements HandlerInterceptor {

    @Autowired
    private IAdminKit adminKit;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        return true;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        if (modelAndView != null) {
            modelAndView.getModel().put("adminKit", adminKit);
        } else {
            request.setAttribute("adminKit", adminKit);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {

    }
}
