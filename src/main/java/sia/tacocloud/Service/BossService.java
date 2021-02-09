package sia.tacocloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.BossCrudRepository;

import java.util.List;

@Service
public class BossService {

    private final BossCrudRepository bossCrudRepository;

    @Autowired
    public BossService(BossCrudRepository bossCrudRepository){
        this.bossCrudRepository = bossCrudRepository;
    }

    public void save(Boss boss){
        bossCrudRepository.save(boss);
    }

    public List<Boss> findBossByNameUseSQL(String name){
        List<Boss> bossByNameUseSQL = bossCrudRepository.findBossByNameUseSQL(name);
        return bossByNameUseSQL;
    }


    public List<Boss> findBossByLikeNameUseSQL(String name){
        List<Boss> bossByLikeNameUseSQL = bossCrudRepository.findBossByLikeNameUseSQL(name);
        return  bossByLikeNameUseSQL;
    }
}
