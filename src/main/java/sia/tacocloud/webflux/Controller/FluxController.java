package sia.tacocloud.webflux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.BossCrudRepository;
import sia.tacocloud.webflux.DAO.BossFluxRepository;

@Controller
public class FluxController {
    private final BossFluxRepository bossFluxRepository;
    @Autowired
    public FluxController(BossFluxRepository bossFluxRepository) {
        this.bossFluxRepository = bossFluxRepository;
    }

  
    @GetMapping("/flux")
    public Flux<Boss> Get(){
        return  bossFluxRepository.findAll();
    }
}
