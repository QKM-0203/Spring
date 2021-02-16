package sia.tacocloud.DAO;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.GetMapping;
import sia.tacocloud.DAO.Boss;


import java.util.List;

@Component
@FeignClient("taco-service")
public interface TacoFeign {
    @GetMapping("/feign")
    List<Boss> getBosses();

}
