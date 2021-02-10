package sia.tacocloud.webflux.DAO;

import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import sia.tacocloud.DAO.User;

import java.util.UUID;


public interface UserReactiveRepository extends ReactiveCrudRepository<User, UUID> {

}
