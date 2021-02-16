package sia.tacocloud.EurekaService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import sia.tacocloud.DAO.Boss;

@Component
public class TacoService {
    @Autowired
    public TacoService(@LoadBalanced RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    private final RestTemplate restTemplate;

    public Boss getBoss(){
        return restTemplate.getForObject("http://taco-service/model/find",Boss.class);
    }
}
