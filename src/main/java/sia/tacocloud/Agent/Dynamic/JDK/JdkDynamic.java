package sia.tacocloud.Agent.Dynamic.JDK;

/**
 * 使用jDK代理需要接口，因为代理对象要看放在那个接口上，如果没有接口可以使用CGLIB代理
 */
public interface JdkDynamic {
    public void demo();
}
