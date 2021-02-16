package sia.tacocloud.EurekaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.TacoFeign;

import java.util.List;

@Controller
public class FeignText {
    private TacoFeign tacoFeign;

    @Autowired
    public FeignText(TacoFeign tacoFeign) {
        this.tacoFeign = tacoFeign;
    }

    @GetMapping("/feign")
    public List<Boss> getBosses(){
        return tacoFeign.getBosses();
    }
}
