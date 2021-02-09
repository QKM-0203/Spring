package sia.tacocloud.webflux.Bean;

import lombok.Data;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@UserDefinedType("information")
public class InformationUID {

    private  final  int ClassID;

    private final int age;

    private final int point;

    private final String sex;
}
