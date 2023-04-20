package com.example.interceptor;


import com.example.pojo.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

public class LoginInterceptor implements HandlerInterceptor {

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler,
                                Exception exception) throws Exception {
        System.out.println("-----调用LoginInterceptor的afterCompletion()方法-----");

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler,
                           ModelAndView modelAndViewodelAndView) throws Exception {
        System.out.println("-----调用LoginInterceptor的postHandle()方法-----");
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
            throws Exception {
        System.out.println("-----调用LoginInterceptor的preHandle()方法-----");
        // 获取请求的URL
        String url = request.getRequestURI();
        // URL:除了login.jsp是可以公开访问的，其它的URL都进行拦截控制
        if (url.indexOf("/login") >= 0) {
            return true;
        }
        // 获取Session
        HttpSession session = request.getSession();
        User user = (User) session.getAttribute("USER_SESSION");
        // 判断Session中是否有用户数据，如果有，则返回true,继续向下执行
        if (user != null) {
            if (url.indexOf("/admin") >= 0&&user.getRoleId()==0){
                return true;
            }
            else if (url.indexOf("/officer") >= 0&&user.getRoleId()==1){
                return true;
            }
            else if (url.indexOf("/treasurer") >= 0&&user.getRoleId()==2){
                return true;
            }
            else if (url.indexOf("/dormadmin") >= 0&&user.getRoleId()==3){
                return true;
            }
            else if (url.indexOf("/secretary") >= 0&&user.getRoleId()==4){
                return true;
            }
            else if (url.indexOf("/freshman") >= 0&&user.getRoleId()==5){
                return true;
            }
            else {
                // 不符合条件的给出提示信息，并转发到登录页面
                request.setAttribute("msg", "您不具备该操作权限");
                request.getRequestDispatcher("/login").forward(request, response);
            }
        }else {
            // 不符合条件的给出提示信息，并转发到登录页面
            request.setAttribute("msg", "您还没有登录，请先登录！");
            request.getRequestDispatcher("/login").forward(request, response);
        }
        return false;
    }

}
