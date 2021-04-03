package sia.tacocloud.BossTest;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import sia.tacocloud.DAO.Mapper.BossMapper;

/**
 * test时配置文件的信息应该写在最上面
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class BossTest1 {

    @Autowired
    private BossMapper bossMapper;

    @Test
    public void test(){
        System.out.println(bossMapper.getListBoss());
    }
}
