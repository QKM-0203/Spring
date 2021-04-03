package sia.tacocloud.Hateoas;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.CollectionModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import sia.tacocloud.DAO.Bean.Boss;
import sia.tacocloud.DAO.BossPageAndSortJPARepository;

import java.util.List;

import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.linkTo;
import static org.springframework.hateoas.server.reactive.WebFluxLinkBuilder.methodOn;

/**
 * 返回超链接的Rest Api
 */
@RequestMapping("/model")
@RestController
public class BossRestResourceController {


    public final BossPageAndSortJPARepository bossPageAndSortJPARepository;

    @Autowired
    public BossRestResourceController(BossPageAndSortJPARepository bossPageAndSortJPARepository) {
        this.bossPageAndSortJPARepository = bossPageAndSortJPARepository;
    }

    /**
     * 获取boss同时每个boss带上超链接有参数id"http://localhost:8080/model/37"
     * @return
     */


    @GetMapping(path="/get" )//表示只会接受请求头Accept=application/json
    public CollectionModel<BossResource> GetBoss(){
        //分页
        PageRequest page= PageRequest.of(0, 4, Sort.by("id").descending());

        //获取list
        List<Boss> tacos = bossPageAndSortJPARepository.findAll(page).getContent();
        //转为带有超链接的
        CollectionModel<BossResource> bossResources =
                new BossResourceAssembler(BossRestResourceController.class, BossResource.class).toCollectionModel(tacos);
        //获取一页boss也就是4个boss的整个路径 有基础路径就是控制器最上面的同时获取该处理方法的路径名字是"boss"
        /*
        "boss"{
           "href":"http://localhost:8080/model/find"
        }
         */
        bossResources.add(linkTo(methodOn(BossRestResourceController.class).GetBoss()).withRel("Boss"));

        return bossResources;
    }
}
