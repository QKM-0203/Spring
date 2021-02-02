package sia.tacocloud.CreateRestApi;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.*;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.BossCrudRepository;

import java.util.List;
import java.util.Optional;

/**
 * 普通的Rest Api
 */


//该注解可以简化响应回去的呈现类型，当处理方法返回Java对象时，这个对象会放在模型中并在视图中渲染使用
//但是，如果使用了消息转换功能的话，我们只需要告诉Spring跳过正常的模型/视图流程，
//并使用消息转换器（spring自带的），有不少方式都能做到这一点，
//最简单的方法是为每个控制器方法添加@ResponseBody（）注解或者整个控制器添加@RestController，或者返回ResponseEntity<Boss>将对象放在响应头中
@RestController// 表示所有处理方法都会使用对应的消息转换器，转换成Accept中对应的类型（请求头中要求响应的的类型）
@RequestMapping("/model")
public class BossRestController {

    private final BossCrudRepository bossCrudRepository;

    @Autowired
    public BossRestController(BossCrudRepository bossCrudRepository) {
        this.bossCrudRepository = bossCrudRepository;
    }

    //get请求一般用来从服务器端获取信息
    @GetMapping(path="/Find",produces = "application/json")//表示只会接受请求头Accept=application/json
    public List<Boss> GetBoss(){
        Iterable<Boss> all = bossCrudRepository.findAll();
        return  (List<Boss>) all;
    }

    //创建
    @GetMapping(path="/add",consumes = "application/json")//表示只会接受请求头中ContentType=application/json，表示请求参数类型为JSON
    public ResponseEntity<Boss> Save(@RequestBody Boss boss){
        Boss save = bossCrudRepository.save(boss);
        //放在响应头中同时状态码为201表示创建一个资源
        return  new ResponseEntity<Boss>(save, HttpStatus.CREATED);
    }

    //删除
    @ResponseStatus(HttpStatus.NO_CONTENT)//响应状态码为没有内容，让用户不要期得到什么内容
    @DeleteMapping("{id}")//表示请求有个参数，底下的注解表示将该请求参数映射给注解里面的id然后赋值给id1
    public ResponseEntity<Boss> delete(@PathVariable("id") int id1){
        Optional<Boss> byId = bossCrudRepository.findById(id1);
        if(byId.isPresent()){
            bossCrudRepository.deleteById(id1);
            return  new ResponseEntity<Boss>(byId.get(),HttpStatus.NO_CONTENT);
        } else{
            return  new ResponseEntity<Boss>((MultiValueMap<String, String>) null,HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping//更新大批数据
    public Boss updatePut(@RequestBody  Boss boss){
        return bossCrudRepository.save(boss);
    }

    @PatchMapping("{bossId}")//更新局部数据
    public Boss updatePatch(@PathVariable("bossId") int id,@RequestBody  Boss boss){
        //通过ID查找返回是Optional可以通过isPresent()判断有没有，然后利用get()来获取
        Boss boss1 = bossCrudRepository.findById(id).get();
        if(boss.getPassword() != null){
            boss1.setPassword(boss.getPassword());
        }
        if(boss.getName() != null){
            boss1.setName(boss.getName());
        }
        return bossCrudRepository.save(boss1);
    }

}
