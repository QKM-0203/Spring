package sia.tacocloud.DAO;

import lombok.Data;
import org.springframework.stereotype.Component;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Data
@Table(name="boss")
@Component
public class Boss1 {

    @Column(name = "name")
    private String name;

    @Column(name = "password")
    private String password;

    @Id
    @Column(name = "ID")
    private Integer id;


}
