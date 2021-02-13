package sia.tacocloud.webflux.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.reactive.EnableWebFluxSecurity;
import org.springframework.security.config.web.server.ServerHttpSecurity;
import org.springframework.security.core.userdetails.ReactiveUserDetailsService;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.web.server.SecurityWebFilterChain;
import reactor.core.publisher.Mono;
import sia.tacocloud.webflux.Bean.User;
import sia.tacocloud.webflux.DAO.UserReactiveRepository;

@Configuration
@EnableWebFluxSecurity
public class SecurityConfig {

    @Bean
    public SecurityWebFilterChain securityWebFilterChain(ServerHttpSecurity http){
               //声明请求级安全性的，
        return http.authorizeExchange()
                .pathMatchers("flux")
                .hasAnyAuthority("USER")
                 //所有的，相当于通配符
                .anyExchange()
                .permitAll()
                //因为我们声明的Bean,没有重写框架的config()方法，所以我们需要将所有的安全规则聚合到一个要返回的SecurityWebFilterChain对象中去
                .and().build();
    }
    //配置反应式用户详情
    @Bean
    public ReactiveUserDetailsService reactiveUserDetailsService(UserReactiveRepository userReactiveRepository){
        return new ReactiveUserDetailsService() {
            @Override
            public Mono<UserDetails> findByUsername(String s) {
                Mono<User> byName = userReactiveRepository.findByName(s);
                User block = byName.block();
              return   byName
                       .map(m-> {
                            return m.userDetails(block);
                        });
            }
        };
    }
}
