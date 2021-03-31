package sia.tacocloud.Controller;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sia.tacocloud.Intercept.LoginHandlerIntercept;

/**
 * 该配置类适用于在控制器里面不用做任何操作直接到视图的一个类，实现该接口覆盖该方法
 * 然后接受的请求为/home转发到home试图去

 * mvc组件增加处，实现WebMvcConfigurer,里面有很多mvc组件
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/Test").setViewName("Test");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截Test路径的页面，静态资源不用过滤，spring boot帮我们做好了
        registry.addInterceptor(new LoginHandlerIntercept()).addPathPatterns("/Test");
    }
}
