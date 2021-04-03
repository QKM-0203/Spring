package sia.tacocloud.DAO.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sia.tacocloud.DAO.Bean.Blog;


import java.util.List;

@Mapper
public interface BlogMapper{

    public List<Blog> getListBlog();

}
