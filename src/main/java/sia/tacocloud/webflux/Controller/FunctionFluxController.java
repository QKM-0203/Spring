package sia.tacocloud.webflux.Controller;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.reactive.function.server.HandlerFunction;
import org.springframework.web.reactive.function.server.RouterFunction;
import org.springframework.web.reactive.function.server.ServerRequest;
import org.springframework.web.reactive.function.server.ServerResponse;
import reactor.core.publisher.Mono;

import static org.springframework.web.reactive.function.server.RequestPredicates.GET;
import static org.springframework.web.reactive.function.server.RouterFunctions.route;
import static org.springframework.web.reactive.function.server.ServerResponse.ok;

@Configuration
public class FunctionFluxController {

    @Bean
    public RouterFunction<?> First() {
        //第一个参数是RequestPredicate声明要处理的类型，第二个是Mono<ServerResponse>类型,写进响应体
        return route(GET("/fun"),
                new HandlerFunction<ServerResponse>() {
                    @Override
                    public Mono<ServerResponse> handle(ServerRequest serverRequest) {
                        return ServerResponse.ok().body(Mono.just("First"),String.class);
                    }
                });
    }
}
