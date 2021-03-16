package sia.tacocloud.Agent.Dynamic.JDK;

import com.ctc.wstx.api.InvalidCharHandler;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JDKAddDynamic implements InvocationHandler {

    //真实对象
    private Object object = null;

    /**
     * 将代理对象和真实对象建立关系
     * @param object 真实对象
     * @return
     */
    public Object getProxy(Object object){
        this.object = object;
        return Proxy.newProxyInstance(object.getClass().getClassLoader(),object.getClass().getInterfaces(),this) ;
    }


    /**
     * 代理对象处理的逻辑
     * @param proxy
     * @param method
     * @param args
     * @return
     * @throws Throwable
     */
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        System.out.println("之前的操作");
        Object invoke = method.invoke(object, args);
        System.out.println("之后的操作");
        return invoke;
    }
}
