package sia.tacocloud.webflux.Bean;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.PrimaryKey;
import org.springframework.data.cassandra.core.mapping.Table;

@Data
@Table("info")
public class Information {
    @PrimaryKey
    private  int ClassID;

    private  int age;

    private  int point;

    private  String sex;

}
