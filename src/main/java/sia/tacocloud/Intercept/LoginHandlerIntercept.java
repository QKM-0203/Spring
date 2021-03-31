package sia.tacocloud.Intercept;

import org.springframework.lang.Nullable;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;


public class LoginHandlerIntercept implements HandlerInterceptor {


    public  boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String login = (String)request.getSession().getAttribute("login");
        if(StringUtils.isEmpty(login)){
            request.setAttribute("msg","请先登录");
            request.getRequestDispatcher("/login").forward(request,response);
            return false;
        }
        return true;
    }


    public  void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable ModelAndView modelAndView) throws Exception {
        System.out.println("返回视图之前执行1");
    }

    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, @Nullable Exception ex) throws Exception {
        System.out.println("返回视图之后执行1");//无论是否产生异常,都会执行，除非preHandler返回false就不会执行。
    }
}
