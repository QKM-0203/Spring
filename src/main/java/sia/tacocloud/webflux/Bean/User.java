package sia.tacocloud.webflux.Bean;

import com.datastax.oss.driver.api.core.uuid.Uuids;
import lombok.Data;
import org.springframework.data.cassandra.core.cql.Ordering;
import org.springframework.data.cassandra.core.cql.PrimaryKeyType;
import org.springframework.data.cassandra.core.mapping.PrimaryKeyColumn;
import org.springframework.data.cassandra.core.mapping.Table;

import java.util.Date;
import java.util.UUID;

@Data
@Table("user")//将对象映射为Cassandra持久化
public class User {
    //其中的一个主键列，作为Cassandra数据库的分区键（用来找该行写在哪一个分区）
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED)
    //32位16进制（UUID）的id数字，不是强制性的，但通常id属性都是UUID类型的
    private UUID id = Uuids.timeBased();

    private String name;
    private String password;

    //另一个主键列，作为Cassandra数据库的集群键（行在分区中维护的顺序）,并且设置降序，表示在分区中，新添加的会在头一行
    @PrimaryKeyColumn(type = PrimaryKeyType.CLUSTERED,ordering = Ordering.DESCENDING)
    private Date createAt;


}
