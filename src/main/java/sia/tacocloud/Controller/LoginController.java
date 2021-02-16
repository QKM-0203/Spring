package sia.tacocloud.Controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class LoginController {

    @PostMapping("/Login")
    public String Test(){
        return "Test";
    }
}