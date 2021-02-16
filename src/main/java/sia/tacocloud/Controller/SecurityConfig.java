package sia.tacocloud.Controller;

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


    @Bean//加密模式，记住这个验证时是加密验证的，那么存的时候也要加密后再存
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
                //当有ROLE_USER身份时就能访问该页面
                .antMatchers("/home")
                .access("hasRole('ROLE_USER')")
                .antMatchers("/*")
                .access("permitAll")//都可以
                .and()
                .formLogin()
                .loginPage("/login")//当访问页需要登录权限时，就定位到该路径，一般都是定位到登录页面，
                //可以使用Spring security 该框架原本的登录页面，也可以自行设定，不写就是默认原本的
                .and()
                .logout();//注销功能
    }


}
