package sia.tacocloud.LoggerTest;


/**
 *
 * 日志输出在文件里面叠加
 */

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class LoggerTest {

    Logger logger = LoggerFactory.getLogger(LoggerTest.class);
    @Test
    public void test(){
        logger.debug("debug1");
        System.out.println("qwe");
    }
}
