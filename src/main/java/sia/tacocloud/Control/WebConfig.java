package sia.tacocloud.Control;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * 该配置类适用于在控制器里面不用做任何操作直接到视图的一个类，实现该接口覆盖该方法
 * 然后接受的请求为/home转发到home试图去
 */
@Configuration
public class WebConfig implements WebMvcConfigurer {
    @Override
    public void addViewControllers(ViewControllerRegistry registry){
        registry.addViewController("/login").setViewName("login");

    }
}
