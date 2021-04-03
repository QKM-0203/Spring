package sia.tacocloud.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import sia.tacocloud.DAO.Bean.Blog;
import sia.tacocloud.DAO.Bean.Boss;
import sia.tacocloud.DAO.BlogCrudRepository;
import sia.tacocloud.DAO.Mapper.BlogMapper;

import java.util.List;

@Controller
public class BlogController {
    private final BlogCrudRepository blogCrudRepository;

    public BlogController(BlogCrudRepository blogCrudRepository) {
        this.blogCrudRepository = blogCrudRepository;
    }


    //spring data JPA自动开启驼峰命名法,遇到大写就转换,第一个大写字母不变
    @GetMapping("/blog")
    public String blogs(Model model){
        Iterable<Blog> all = blogCrudRepository.findAll();
        model.addAttribute("blogs",all);
        return  "dashBoard1";
    }


    @Autowired
    private BlogMapper blogMapper;


    @GetMapping("/blogMybatis")
    @ResponseBody
    public List<Blog> blogsMybatis(Model model){
        List<Blog> listBlog = blogMapper.getListBlog();
        return  listBlog;
    }
}
