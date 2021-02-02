package sia.tacocloud.CreateRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.BossCrudRepository;

import java.util.List;

//该注解可以简化响应回去的呈现类型，当处理方法返回Java对象时，这个对象会放在模型中并在视图中渲染使用
//但是，如果使用了消息转换功能的话，我们只需要告诉Spring跳过正常的模型/视图流程，
//并使用消息转换器（spring自带的），有不少方式都能做到这一点，
//最简单的方法是为每个控制器方法添加@ResponseBody（）注解或者整个控制器添加@RestController，或者返回ResponseEntity<Boss>将对象放在响应头中
// 表示所有处理方法都会使用对应的消息转换器，转换成Accept中对应的类型（请求头中要求响应的的类型）
@RestController
@RequestMapping("/restapi")
public class BossTextController {

    private final BossCrudRepository bossCrudRepository;

    @Autowired
    public BossTextController(BossCrudRepository bossCrudRepository) {
        this.bossCrudRepository = bossCrudRepository;
    }

    //get请求一般用来从服务器端获取信息
    @GetMapping(produces = "application/json")//表示只会接受请求头Accept=application/json
    public List<Boss> GetBoss(){
        Iterable<Boss> all = bossCrudRepository.findAll();
        return  (List<Boss>) all;
    }

    //创建
    @PostMapping(consumes = "application/json")//表示只会接受请求头中ContentType=application/json，表示请求参数类型为JSON
    public ResponseEntity<Boss> Save(@RequestBody Boss boss){
        Boss save = bossCrudRepository.save(boss);
        //放在响应头中同时状态码为201表示创建一个资源
        return  new ResponseEntity<Boss>(save, HttpStatus.CREATED);
    }

    //删除
    @DeleteMapping("{id}")//表示请求有个参数，底下的注解表示将该请求参数映射给注解里面的id然后赋值给id1
    public void delete(@PathVariable("id") int id1){
        bossCrudRepository.deleteById(id1);
    }

    @PutMapping//更新大批数据
    public Boss update(@RequestBody  Boss boss){
        return bossCrudRepository.save(boss);
    }

}
