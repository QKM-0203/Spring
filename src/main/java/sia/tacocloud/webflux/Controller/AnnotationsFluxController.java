package sia.tacocloud.webflux.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import reactor.core.publisher.Flux;
import sia.tacocloud.DAO.User;
import sia.tacocloud.webflux.DAO.UserReactiveRepository;

@Controller
public class AnnotationsFluxController {
    private final UserReactiveRepository userReactiveRepository;
    @Autowired
    public AnnotationsFluxController(UserReactiveRepository userReactiveRepository) {
        this.userReactiveRepository = userReactiveRepository;
    }

  
    @GetMapping("/flux")
    public Flux<User> Get(){
        return  userReactiveRepository.findAll();
    }
}
