package sia.tacocloud.Control;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.test.context.junit4.SpringRunner;
import sia.tacocloud.Configuration.ConfigurationProps;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.BossPageAndSortJPARepository;

import java.util.List;
import java.util.function.Consumer;

@RunWith(SpringRunner.class)
@SpringBootTest
public class UserPageText {

    @Autowired
    private ConfigurationProps configurationProps;

    @Autowired
    private BossPageAndSortJPARepository bossPageAndSortJPARepository;

    /**
     * 分页
     */
    @Test
    public void test1(){
        int page = 2; //page:当前页的索引。注意索引都是从0开始的。
       //PageSize显示每页多少条数据，这里使用自定义配置属性，属性源是应用配置文件
        //数据库页数从0开始
        //获取PageRequest的新方法，新版本
        Pageable pageable= PageRequest.of(page-1,configurationProps.getPageSize());
        Page<Boss> p = this.bossPageAndSortJPARepository.findAll(pageable);
        System.out.println("数据的总条数："+p.getTotalElements());
        System.out.println("总页数："+p.getTotalPages());
        //获取当前页的数据
        List<Boss> list = p.getContent();
        for (Boss boss : list) {
            System.out.println(boss.getId()+" "+boss.getPassword());
        }
    }

    @Test
    public void Text(){
        //获取Sort的新方法,新版本,对password先排序,在进行分页，如果不分页就直接传入sort就行，依情况而定
        Sort password = Sort.by(Sort.Direction.DESC, "password");
        Pageable  of = PageRequest.of(0, 3, password);
        Iterable<Boss> all = bossPageAndSortJPARepository.findAll(of);
        all.forEach(boss -> System.out.println(boss.getId()+" "+boss.getPassword()));
    }
}