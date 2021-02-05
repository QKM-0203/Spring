package sia.tacocloud.JMS;
import lombok.Data;

import java.io.Serializable;
import java.util.Date;

@Data
public class Message implements Serializable {
    private  String Text;
    private Date date;
}
