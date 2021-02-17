package sia.tacocloud.EurekaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.DAO.Boss;

import java.util.List;

@Controller
public class FeignText {
    private TacoFeign tacoFeign;

    @Autowired
    public FeignText(TacoFeign tacoFeign) {
        this.tacoFeign = tacoFeign;
    }

    /**
     * 有问题
     * @param model
     * @return
     */
    @GetMapping("/feign")
    public String getBosses(Model model){
        tacoFeign.getBosses();
        return "login";
    }
}
