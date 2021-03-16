package sia.tacocloud.Observer;

import java.util.Observable;
import java.util.Observer;

public class Tao implements Observer {
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("成功增加T"+(String)arg);
    }
}
