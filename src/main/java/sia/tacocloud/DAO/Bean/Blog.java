package sia.tacocloud.DAO.Bean;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="blog")
@Component
public class Blog {

    private String bossId;
    private String think;


    @Id
    //@Column(name="creatAtAndName")
    private String creatAtAndName;
}
