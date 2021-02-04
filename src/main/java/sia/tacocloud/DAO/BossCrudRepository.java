package sia.tacocloud.DAO;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


public interface BossCrudRepository extends CrudRepository<Boss,Integer> {

    //启用SQL查询
    @Query(value ="select * from boss where name = ?",nativeQuery=true)
    List<Boss> findBossByNameUseSQL(String name);

    @Query(value="select * from boss where name like ?",nativeQuery=true)
    List<Boss> findBossByLikeNameUseSQL(String name);

    @Query(value ="select * from boss where name = ?",nativeQuery=true)
    Boss findBossByNameUse(String name);
}
