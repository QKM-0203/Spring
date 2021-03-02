package sia.tacocloud.Agent.Static;

public class JdkStaticImplAgent implements JdkStatic{
    public JdkStatic jdkStatic;

    public JdkStaticImplAgent(JdkStatic jdkStatic){
        this.jdkStatic = jdkStatic;
    }

    @Override
    public void demo() {
        System.out.println("静态前增加操作");
        jdkStatic.demo();
        System.out.println("静态后增加操作");
    }
}
