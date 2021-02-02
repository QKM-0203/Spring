package sia.tacocloud.Hateoas;

import lombok.Getter;
import org.springframework.hateoas.RepresentationModel;
import sia.tacocloud.DAO.Boss;

public class BossResource extends RepresentationModel<BossResource> {
    @Getter
    private final String name;


    @Getter
    private final String password;

    public BossResource(Boss boss){
        this.name = boss.getName();
        this.password = boss.getPassword();
    }
}
