package sia.tacocloud.Agent.Text;

import sia.tacocloud.Agent.Dynamic.JDK.JDKAddDynamic;
import sia.tacocloud.Agent.Dynamic.JDK.JdkDynamic;
import sia.tacocloud.Agent.Dynamic.JDK.JdkDynamicImpl;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKDynamicText {
    public static void main(String[] args) {

        JDKAddDynamic jdkAddDynamic = new JDKAddDynamic();

        //将代理对象挂在JDkDynamic接口上
        JdkDynamic proxy = (JdkDynamic) jdkAddDynamic.getProxy(new JdkDynamicImpl());

        proxy.demo();
    }
}
