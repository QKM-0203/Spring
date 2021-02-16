package sia.tacocloud.EurekaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;
import sia.tacocloud.DAO.Boss;


@RestController
public class TacoService {

    private final RestTemplate restTemplate;

    @Autowired
    public TacoService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @GetMapping("/test")
    public String getBoss(){
        Boss forObject = restTemplate.getForObject("http://taco-service/model/Find/1", Boss.class);
        System.out.println(forObject.getName());
        return "yes";
    }
}
