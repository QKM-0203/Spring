package sia.tacocloud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/first")
    public String Test(@RequestParam("username") String name, @RequestParam("password") String password,
                       Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(name) && "123".equals(password)){
            session.setAttribute("login","true");
            //防止表单重复提交可以使用重定向
            return "redirect:/Test";
            //return "Test";
        }
        map.put("msg","用户名或密码错误");
        return "index";
    }
}