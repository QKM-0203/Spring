package sia.tacocloud.webflux.DAO;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import sia.tacocloud.DAO.Boss;


public interface BossFluxRepository extends ReactiveCrudRepository<Boss,Integer> {

}
