package sia.tacocloud.Configuration;

import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.boot.web.servlet.ServletListenerRegistrationBean;
import org.springframework.boot.web.servlet.ServletRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import sia.tacocloud.Controller.MyLocaleResolve;
import sia.tacocloud.Filter.MyFilter;
import sia.tacocloud.Intercept.LoginHandlerIntercept;
import sia.tacocloud.Listen.MyListen;
import sia.tacocloud.Servlet.MyServlet;

import java.util.Arrays;

/**
 * 该配置类适用于在控制器里面不用做任何操作直接到视图的一个类，实现该接口覆盖该方法
 * 然后接受的请求为/home转发到home试图去

 * mvc组件增加处，实现WebMvcConfigurer,里面有很多mvc组件
 *
 *
 * 嵌入式servlet容器,spring boot 为我们提供了多种服务器工厂,通过该工厂对象就可以创建servlet容器,然后只要容器中添加组件,就会惊动后置处理器
 * ,后置处理器工作就是从定制器中获取容器中所有的定制器,就可以调用定制器中的得所有定制方法
 *
 *
 *
 * 获取嵌入式的容器:
 * spring boot应用启动
 * refresh(context)spring boot刷新IOC 容器,并初始化容器,创建容器中的组件,初始化容器的时候,会判断是webIOC容器还是默认的IOC 容器
 * 刷新刚才创建好的IOC容器
 * webIOC创建嵌入式的servlet容器
 * 获取嵌入式的Servlet容器工厂
 * 使用容器工厂获取嵌入式的servlet容器
 * 启动嵌入式容器
 *
 *
 * 总结一句话:先创建嵌入式容器,在创建IOC容器中的其余组件,IOC容器启动创建嵌入式容器
 * */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {

    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("index");
        registry.addViewController("/Test").setViewName("Test");
        registry.addViewController("/dashBoard").setViewName("dashBoard");
        registry.addViewController("/dashBoard1").setViewName("dashBoard1");
        registry.addViewController("/snake").setViewName("snake");

    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //拦截Test路径的页面，静态资源不用过滤，spring boot帮我们做好了
        registry.addInterceptor(new LoginHandlerIntercept()).addPathPatterns("/Test");
    }

    /**
     * 将自己设置的localeResolve添加到Spring容器里,加上4个组件注解好像没用
     * @return
     */
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolve();
    }


    @Bean
    public ServletRegistrationBean servletRegistrationBean(){
        return new ServletRegistrationBean(new MyServlet(),"/servlet");
    }


    @Bean
    public FilterRegistrationBean filterRegistrationBean(){
        FilterRegistrationBean<MyFilter> myFilterFilterRegistrationBean = new FilterRegistrationBean<>();
        myFilterFilterRegistrationBean.setFilter(new MyFilter());
        myFilterFilterRegistrationBean.setUrlPatterns(Arrays.asList("/login","/Test"));
        return myFilterFilterRegistrationBean;
    }


    @Bean
    public ServletListenerRegistrationBean servletListenerRegistrationBean(){
        ServletListenerRegistrationBean<MyListen> myListenServletListenerRegistrationBean = new ServletListenerRegistrationBean<>();
       myListenServletListenerRegistrationBean.setListener(new MyListen());
       return myListenServletListenerRegistrationBean;
    }

}
