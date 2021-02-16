package sia.tacocloud.EurekaService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;

@Component
@FeignClient("taco-service")
public interface TacoFeign {
    @GetMapping("/model/Find")
    void getBosses();

}
