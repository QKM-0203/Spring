package sia.tacocloud.Service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import sia.tacocloud.DAO.Boss;
import sia.tacocloud.DAO.BossCrudRepository;

@Service
public class BossDIYSecurityService implements UserDetailsService {

    public final BossCrudRepository bossCrudRepository;

    @Autowired
    public BossDIYSecurityService(BossCrudRepository bossCrudRepository){
        this.bossCrudRepository = bossCrudRepository;
    }



    @Override
    public UserDetails loadUserByUsername(String s) throws UsernameNotFoundException {
        Boss bossByNameUse = bossCrudRepository.findBossByNameUse(s);
        if(bossByNameUse != null){
            return bossByNameUse;
        }
        throw new UsernameNotFoundException("User '"+s+"' not found");
    }
}
