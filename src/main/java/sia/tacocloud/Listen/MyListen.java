package sia.tacocloud.Listen;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

public class MyListen implements ServletContextListener {
    @Override
    public void contextInitialized(ServletContextEvent sce) {
        System.out.println("web启动");
    }

    @Override
    public  void contextDestroyed(ServletContextEvent sce) {
        System.out.println("web销毁");
    }
}
