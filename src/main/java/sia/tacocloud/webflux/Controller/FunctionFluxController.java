package sia.tacocloud.webflux.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.RouterFunction;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class FunctionFluxController {

    @Bean
    public RouterFunction<?> First() {
        return route(GET("/fun"),request->ok().body(Mono.just("First"),String.class));

    }
}
