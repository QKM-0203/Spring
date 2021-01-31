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

    public List<Boss> findBossByNameUseJPQL(String name){
        List<Boss> bossByNameUseJPQL = bossCrudRepository.findBossByNameUseSQL(name);
        return bossByNameUseJPQL;
    }


    public List<Boss> findBossByLikeNameUseJPQL(String name){
        List<Boss> bossByLikeNameUseJPQL = bossCrudRepository.findBossByLikeNameUseSQL(name);
        return  bossByLikeNameUseJPQL;
    }
}
