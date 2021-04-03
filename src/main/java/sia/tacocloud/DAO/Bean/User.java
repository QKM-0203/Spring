package sia.tacocloud.DAO.Bean;

import com.sun.istack.NotNull;
import lombok.Data;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Data
@Table(name="user")
public class User {
    //主键
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int ID;

    @NotNull
    private String NAME;
    @NotNull
    private String SEX;
    @NotNull
    private int AGE;
    @NotNull
    private String Birth;
    @NotNull
    private String QQ;
    @NotNull
    private String MAIL;
}
