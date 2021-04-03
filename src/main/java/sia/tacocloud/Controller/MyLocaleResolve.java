package sia.tacocloud.Controller;


import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import java.util.Locale;

/**
 * 默认的区域解析器是根据请求头来解析是要中文还是英文,所有你如果使用自己设置的区域解析器，就写一个方法将该类变成bean加到spring 容器,
 * 在一个配置类里面就可以里面
 */


public class MyLocaleResolve implements LocaleResolver {

    @Override
    public Locale resolveLocale(HttpServletRequest httpServletRequest) {
        String i = httpServletRequest.getParameter("I");
        //获取系统默认的
        Locale locale = Locale.getDefault();
        if(!StringUtils.isEmpty(i)){
            String[] s = i.split("_");
            locale = new Locale(s[0],s[1]);
        }
        return locale;
    }


    @Override
    public void setLocale(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Locale locale) {

    }


}
