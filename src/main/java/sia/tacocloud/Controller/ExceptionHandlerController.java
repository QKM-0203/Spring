package sia.tacocloud.Controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import sia.tacocloud.Exception.MyException;

import javax.servlet.http.HttpServletRequest;
import java.util.HashMap;
import java.util.Map;

@ControllerAdvice
public class ExceptionHandlerController {


    //我理解的的是处理哪一个异常类
    @org.springframework.web.bind.annotation.ExceptionHandler(MyException.class)
    //@ResponseBody
    public String  handlerException(Exception e, HttpServletRequest httpServletRequest) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //将异常信息存到map里面
        map.put("message", e.getMessage());

        //要设置错误状态码,才能跳转到自己设定的错误页面
        httpServletRequest.setAttribute("javax.servlet.error.status_code", 500);

        // /error 请求,该请求被BasicErrorController处理,同时相应出去的信息,是由getErrorAttributes
        // 获取的,所以可以自己添加一些属性继承DefaultErrorAttribute类然后覆盖其中的方法
        // 可以返回错误页面形式,也可以返回错误JSON形式,就是可以根据客户端不同返回不同形式的页面,返回不同的形式 /error请求就可以自己做到
        httpServletRequest.setAttribute("ext", map);
        // return map;
        //只有访问该请求才可以访问到自己添加的错误属性,就相当于调用了MyErrorAttribute里面的getErrorAttribute方法
        //因为/error 请求会调用getErrorAttribute方法.获取错误属性
        //如果使用@ResponseBody注解则不会转发到该请求相当于就没有跳转到错误页面,而是直接在当前页面展现"forward:/error"
        return "forward:/error";


        //不加@ResponseBody注解 则和/error 请求结果一样调用getErrorAttribute方法,可以获取自己设置的属性和一些自带的属性
        //return map;
    }



    @org.springframework.web.bind.annotation.ExceptionHandler
    public String  handlerException1(Exception e, HttpServletRequest httpServletRequest) {
        HashMap<String, Object> map = new HashMap<String, Object>();
        //将异常信息存到map里面
        map.put("message", e.getMessage());

        httpServletRequest.setAttribute("javax.servlet.error.status_code", 500);

        httpServletRequest.setAttribute("ext", map);

        return "forward:/error";
    }
}
