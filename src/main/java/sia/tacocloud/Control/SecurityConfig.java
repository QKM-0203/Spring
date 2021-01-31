package sia.tacocloud.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import sia.tacocloud.Service.BossDIYSecurityService;

@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final BossDIYSecurityService bossDIYSecurityService;

    public SecurityConfig(BossDIYSecurityService bossDIYSecurityService) {
        this.bossDIYSecurityService = bossDIYSecurityService;
    }


    @Bean//加密模式
    public PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
         auth.userDetailsService(bossDIYSecurityService).passwordEncoder(encode());
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home","/")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/*")
                .access("permitAll")
                .and()
                .formLogin()
                .loginPage("/login")
                .usernameParameter("name")	//自定义用户名请求参数名
                .passwordParameter("password")
                .defaultSuccessUrl("/home");
    }
}
