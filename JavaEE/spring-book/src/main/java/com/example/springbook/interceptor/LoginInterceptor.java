package com.example.springbook.interceptor;

import com.example.springbook.constant.Constants;
import com.example.springbook.model.UserInfo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

@Component
@Slf4j
public class LoginInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("登录拦截器校验...");
//        返回true表示放行，返回false表示拦截
        //校验用户是否登录
        HttpSession session = request.getSession(false);//表示没有session不创建，直接返回
        if (session != null && session.getAttribute(Constants.SESSION_USER_KEY) != null) {
            UserInfo userInfo = (UserInfo)session.getAttribute(Constants.SESSION_USER_KEY);
            if (userInfo != null && userInfo.getId() >= 0) {
                return true;
            }
        }
        response.setStatus(401);//401 表示未认证登录
        return false;
    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        log.info("目标方法执行后");
    }
}
