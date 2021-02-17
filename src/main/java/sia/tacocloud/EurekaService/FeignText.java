package sia.tacocloud.EurekaService;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.DAO.Boss1;

import java.util.List;

@RestController
public class FeignText {
    private TacoFeign tacoFeign;

    @Autowired
    public FeignText(TacoFeign tacoFeign) {
        this.tacoFeign = tacoFeign;
    }

    /**
     * 解决成功，不能使用Boss，要用Boss1，Boss里面有很多权限问题，暂时不知道什么问题
     * @param
     * @return
     */
    @GetMapping("/feign")
    public List<Boss1> getBosses(){
        List<Boss1> bosses = tacoFeign.getBosses();
        return bosses;
    }
}
