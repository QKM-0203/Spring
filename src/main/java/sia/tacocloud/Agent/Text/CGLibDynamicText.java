package sia.tacocloud.Agent.Text;

import sia.tacocloud.Agent.Dynamic.CGLIB.CGLibAddDynamic;
import sia.tacocloud.Agent.Dynamic.CGLIB.CGLibDynamic;

public class CGLibDynamicText {
    public static void main(String[] args) {

        CGLibAddDynamic cgLibAddDynamic = new CGLibAddDynamic();

        //获取代理对象
        CGLibDynamic proxy = (CGLibDynamic) cgLibAddDynamic.getProxy(CGLibDynamic.class);

        proxy.demo();

    }
}
