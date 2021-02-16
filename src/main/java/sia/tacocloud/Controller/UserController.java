package sia.tacocloud.Controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import sia.tacocloud.DAO.Tester;

@Slf4j
@Controller
public class UserController {
    private Tester tester;

    @Autowired
    public UserController(Tester tester){
        this.tester = tester;
    }

    @GetMapping("/home")
    public String home(Model model){
        tester.setName("qkm");
        tester.setId(12);
        model.addAttribute("tester", tester);
        return "home";
    }
}