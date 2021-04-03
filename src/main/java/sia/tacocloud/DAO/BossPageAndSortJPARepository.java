package sia.tacocloud.DAO;

import org.springframework.data.repository.PagingAndSortingRepository;
import sia.tacocloud.DAO.Bean.Boss;

public interface BossPageAndSortJPARepository extends PagingAndSortingRepository<Boss, Integer> {

}
