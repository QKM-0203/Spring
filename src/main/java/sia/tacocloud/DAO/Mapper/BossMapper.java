package sia.tacocloud.DAO.Mapper;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import sia.tacocloud.DAO.Bean.Boss;

import java.util.List;

@Mapper
public interface BossMapper {
    @Select("select * from boss")
    public List<Boss> getListBoss();

}
