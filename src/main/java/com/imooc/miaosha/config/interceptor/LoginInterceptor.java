package com.imooc.miaosha.config.interceptor;

import com.imooc.miaosha.service.MiaoshaUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Service
public class LoginInterceptor extends HandlerInterceptorAdapter {

    @Autowired
    MiaoshaUserService miaoshaUserService;

    @Override
    public boolean preHandle(HttpServletRequest request,
                             HttpServletResponse response,
                             Object handler) throws Exception {
//        request.getCookies()
//        String paramToken = request.getParameter(MiaoshaUserService.COOKI_NAME_TOKEN);
        String cookieToken = getCookieValue(request, MiaoshaUserService.COOKI_NAME_TOKEN);
//        System.out.println(paramToken);
//        System.out.println(cookieToken);
//        System.out.println(request.getHeader(MiaoshaUserService.COOKI_NAME_TOKEN));
        if (cookieToken == null) {
            response.sendRedirect("/login/to_login");
            return false;
        }
        return true;
    }
    private String getCookieValue(HttpServletRequest request, String cookiName) {
        Cookie[]  cookies = request.getCookies();
        if(cookies == null || cookies.length <= 0){
            return null;
        }
        for(Cookie cookie : cookies) {
            if(cookie.getName().equals(cookiName)) {
                return cookie.getValue();
            }
        }
        return null;
    }
}
