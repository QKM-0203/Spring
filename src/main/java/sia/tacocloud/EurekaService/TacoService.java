package sia.tacocloud.EurekaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.Boss1;


@RestController
public class TacoService {

    public final RestTemplate restTemplate;

    @Autowired
    public TacoService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }


    /**
     *
     * 不能用Boss因为Boss类有一些权限问题就导致不能成功调用
     * @return
     */
    @GetMapping("/test")
    public Boss1 getBoss1(){
        ResponseEntity<Boss1> forEntity = restTemplate.getForEntity("http://taco-service/model/Find/{id}", Boss1.class,1);
        return forEntity.getBody();
    }

    @GetMapping("/test1")
    public Boss1 getBoss2(){
        Boss1 forObject = restTemplate.getForObject("http://taco-service/model/Find/{id}", Boss1.class, 1);
        return forObject;
    }
}
