package sia.tacocloud.webflux.Bean;

import lombok.AccessLevel;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.data.cassandra.core.mapping.UserDefinedType;

@Data
@NoArgsConstructor(access = AccessLevel.PRIVATE,force = true)
@RequiredArgsConstructor
@UserDefinedType("information")
public class InformationUID {

    private  final  int ClassID;

    private final int age;

    private final int point;

    private final String sex;
}
