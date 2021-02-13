package sia.tacocloud.webflux.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.reactive.ReactiveCrudRepository;
import reactor.core.publisher.Mono;
import sia.tacocloud.webflux.Bean.User;

import java.util.UUID;


public interface UserReactiveRepository extends ReactiveCrudRepository<User, UUID> {
     @Query(value = "select * from User where name = ?",nativeQuery = true)
     public Mono<User> findByName(String name);

}
