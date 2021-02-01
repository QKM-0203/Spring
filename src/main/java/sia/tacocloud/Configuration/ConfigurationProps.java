package sia.tacocloud.Configuration;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
@Data
@Component
@ConfigurationProperties(prefix = "taco.diy")
public class ConfigurationProps {
    private int PageSize;
}
