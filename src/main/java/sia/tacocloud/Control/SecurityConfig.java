package sia.tacocloud.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;


@Configuration
public class SecurityConfig extends WebSecurityConfigurerAdapter {

    private final UserDetailsService userDetailsService;

    @Autowired
    public SecurityConfig(@Qualifier("bossDIYSecurityService") UserDetailsService userDetailsService) {
        this.userDetailsService = userDetailsService;

    }


    @Bean//加密模式
    public PasswordEncoder encode(){
        return new BCryptPasswordEncoder();
    }

    @Override
    protected  void configure(AuthenticationManagerBuilder auth) throws Exception {
       auth.userDetailsService(userDetailsService).passwordEncoder(encode());
    }

    @Override
    protected  void configure(HttpSecurity http) throws Exception {
        http.authorizeRequests()
                .antMatchers("/home")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/*")
                .access("permitAll")
                .and()
                .formLogin()
                .loginPage("/login")
                .loginProcessingUrl("/Login/Test")
                .defaultSuccessUrl("/home")
                .and()
                .logout();
    }
}
