package sia.tacocloud.Configuration;

import lombok.Data;
import org.apache.commons.beanutils.locale.LocaleBeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.LocaleResolver;
import sia.tacocloud.Controller.MyLocaleResolve;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;
import java.util.Locale;
import java.util.Map;


/**
 * @ConfigurationProperties和@Value的异同
 * 不同：
 * 1 长的支持JSR303校验，短的不支持，
 * 2 短的支持spel表达式，长的不支持
 * 3 长的支持复杂类型的读取
 * 4 长的支持松散绑定 lsat_name == lastName,短的不支持
 * 相同
 * 1 都支持从配置文件读取基本类型
 */
//有大括号的就支持数组也就是多个
//@PropertySource(value = {"classpath:PropertySource.yml","classpath:PropertySource.yml"})
//@ImportResource(locations = {"classpath:XXX"})用来加载spring的xml文件的
@Data
@Component
@Validated//校验
@ConfigurationProperties(prefix = "test")//支持校验,还得加上面的注解//默认扫描全局配置文件的，application
public class ConfigurationProps {


//    //不能为空且必须是email格式
//    @NotNull
//    @Email
//    @Value("${taco.diy.PageSize}")//不支持校验
//    private int PageSize;
//
//    private Map<String,String> map;
//
//    @Value("${source.one}")
//    private int  one;

    private String one1;




    @Bean//Bean注解相当与spring的xml文件的bean配置，方法名就是他的id
    @LoadBalanced
    public RestTemplate restTemplate(){
        return new RestTemplate();
    }





}
