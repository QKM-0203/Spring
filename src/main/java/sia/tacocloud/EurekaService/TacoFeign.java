package sia.tacocloud.EurekaService;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import org.springframework.web.bind.annotation.GetMapping;
import sia.tacocloud.DAO.Bean.Boss1;

import java.util.List;

@Component
@FeignClient("taco-service")
public interface TacoFeign {
    //只要调用该方法，就会对该方法发起Get和如下路径请求，同时该类的所有方法都是一FeignClient参数的服务实例
    @GetMapping("/model/Find")
    List<Boss1> getBosses();

}
