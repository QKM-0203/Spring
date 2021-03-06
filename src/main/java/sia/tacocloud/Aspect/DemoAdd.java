package sia.tacocloud.Aspect;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class DemoAdd {


    @Before(value = "execution( * sia.tacocloud.Aspect.Demo1.demo(..))")
    public void before(){
        System.out.println("正常操作之前的操作");
    }
}
