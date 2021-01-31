package sia.tacocloud.DAO;

import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * PagingAndSortingRepository
 * @author Administrator
 * 分页处理
 *
 */
public interface UsersDao extends PagingAndSortingRepository<User, Integer> {

}
