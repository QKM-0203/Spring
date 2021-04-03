package sia.tacocloud.Exception;

import org.springframework.boot.web.error.ErrorAttributeOptions;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.stereotype.Component;
import org.springframework.web.context.request.WebRequest;

import java.util.Map;

//给容器中添加自定义的错误属性
@Component
public class MyErrorAttribute extends DefaultErrorAttributes {
    @Override
    public Map<String, Object> getErrorAttributes(WebRequest webRequest, ErrorAttributeOptions options) {
        Map<String, Object> map = super.getErrorAttributes(webRequest, options);
        //{timestamp=Sat Apr 03 13:58:19 CST 2021, status=500, error=Internal Server Error, trace=sia.tacocloud.Exception.MyException: 密码错误
        //, message=密码错误, path=/spring/first}
      //  System.out.println(map);
       // map.put("demo", "测试");
        //System.out.println("返回map也输出");
        //0代表从request域中获取
        Map<String, Object> ext = (Map<String, Object>) webRequest.getAttribute("ext", 0);
        map.put("Exception", ext);
        return map;
    }

}
