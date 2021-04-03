package sia.tacocloud.DAO;

import org.springframework.data.repository.CrudRepository;
import sia.tacocloud.DAO.Bean.Blog;

public interface BlogCrudRepository extends CrudRepository<Blog,String> {

}
