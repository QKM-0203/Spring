package sia.tacocloud.Agent.Text;

import sia.tacocloud.Agent.Static.JdkStatic;
import sia.tacocloud.Agent.Static.JdkStaticImpl;
import sia.tacocloud.Agent.Static.JdkStaticImplAgent;

public class StaticText {
    public static void main(String[] args) {
        //没有代理前
        JdkStatic jdkStatic = new JdkStaticImpl();
        jdkStatic.demo();

        System.out.println("--------------------------");

        //增加静态代理
        JdkStatic jdkStaticImplAgent = new JdkStaticImplAgent(jdkStatic);
        jdkStaticImplAgent.demo();

    }
}
