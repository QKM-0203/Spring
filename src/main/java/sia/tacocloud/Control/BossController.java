package sia.tacocloud.Control;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import sia.tacocloud.DAO.Boss;

import sia.tacocloud.Service.BossService;

import java.util.List;

@Controller
public class BossController {

    private final Boss boss;

    private final BossService bossService;

    private final SecurityConfig securityConfig;
    @Autowired
    public BossController(BossService bossService, Boss boss,SecurityConfig securityConfig){
        this.bossService = bossService;
        this.boss = boss;
        this.securityConfig = securityConfig;
       }

    @GetMapping("/save")
    public String Text(){
        boss.setId(null);
        boss.setName("123");
        boss.setPassword(securityConfig.encode().encode("123456"));
        bossService.save(boss);
        //自定义方法Spring Data JPA
        List<Boss> sc = bossService.findBossByNameUseJPQL("申聪");
        System.out.println(sc.toString());
        List<Boss> s = bossService.findBossByLikeNameUseJPQL("%申%");
        System.out.println(s.toString());
        return "home";
   }
}
