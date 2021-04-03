package sia.tacocloud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.HttpSessionRequiredException;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import sia.tacocloud.Exception.MyException;

import javax.servlet.http.HttpSession;
import java.util.Map;

@Controller
public class LoginController {

    @PostMapping("/first")

  // 这个注解不能用于 redirect/forward 因为会造成直接输出字符串@ResponseBody
    public String Test(@RequestParam("username") String name, @RequestParam("password") String password,
                       Map<String,Object> map, HttpSession session){
        if(!StringUtils.isEmpty(name) && "123".equals(password)){
            session.setAttribute("login","true");
            //在相同的一次会话中产生的sessionId是一样的,就是开一次中的所有网页,将这一次中的所有网页关闭才叫一次会话
//            System.out.println(session.getId());
            //防止表单重复提交可以使用重定向
            return "redirect:/Test";
            //return "Test";
        }else{
            map.put("msg","用户名或密码错误");
            throw new MyException();
        }
    }
}