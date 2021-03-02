package sia.tacocloud.Agent.Text;

import sia.tacocloud.Agent.Dynamic.JdkDynamic;
import sia.tacocloud.Agent.Dynamic.JdkDynamicImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicText {
    public static void main(String[] args) {
        JdkDynamic jdkDynamic = new JdkDynamicImpl();

        JdkDynamic jdkDynamic1 = (JdkDynamic)Proxy.newProxyInstance(JdkDynamicImpl.class.getClassLoader(), JdkDynamicImpl.class.getInterfaces(), new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                        System.out.println("增加动态代理前操作");
                        method.invoke(jdkDynamic, args);
                        System.out.println("增加动态代理后操作");
                        return null;
                    }
                }
        );
        jdkDynamic1.demo();
    }
}
