package sia.tacocloud.Agent.Dynamic.CGLIB;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionDefinition;
import org.springframework.transaction.TransactionException;
import org.springframework.transaction.TransactionStatus;

import java.lang.reflect.Method;

public class CGLibAddDynamic implements MethodInterceptor {

    /**
     * 建立代理对象和真实对象的关系
     * @param cls
     * @return
     */
    public Object getProxy(Class cls){

        //增强类对象
        Enhancer enhancer = new Enhancer();

       //设置增强类型，相当于把被增强的当成父类
        enhancer.setSuperclass(cls);

        //设置代理逻辑对象，要求该对象必须实现MethodInterceptor接口
        enhancer.setCallback(this);

        //生成并返回代理对象
        return enhancer.create();

    }


    /**
     * 代理对象的逻辑处理
     * @param o
     * @param method
     * @param objects
     * @param methodProxy
     * @return
     * @throws Throwable
     */
    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("之前的操作");
        Object o1 = methodProxy.invokeSuper(o,objects);
        System.out.println("之后的操作");
        return  o1;
    }
}
