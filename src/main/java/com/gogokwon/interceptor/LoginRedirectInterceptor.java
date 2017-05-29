package com.gogokwon.interceptor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * @author tinywind
 * @since 2017-05-23
 */
@Component
public class LoginRedirectInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    private HttpSession session;

    private Boolean login() {
        return session.getAttribute("user") != null;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (!(handler instanceof HandlerMethod))
            return true;

        HandlerMethod method = (HandlerMethod) handler;

        LoginRequired classAnnotation = method.getBeanType().getDeclaredAnnotation(LoginRequired.class);
        LoginRequired methodAnnotation = method.getMethodAnnotation(LoginRequired.class);
        if (classAnnotation == null && methodAnnotation == null)
            return true;

        if (login())
            return true;

        if (request.getRequestURI().equals("/login"))
            return true;

        String redirectUrl = "/login?to=" + request.getRequestURI();
        response.sendRedirect(redirectUrl);

        System.out.println("redirectUrl: " + redirectUrl);

        return false;
    }
}
