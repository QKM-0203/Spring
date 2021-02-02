package sia.tacocloud.Hateoas;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import sia.tacocloud.DAO.Boss;

/**
 * 资源装配器，将Boss-BossResource
 */
public class BossResourceAssembler extends RepresentationModelAssemblerSupport<Boss,BossResource> {


    public BossResourceAssembler(Class<BossRestResourceController> controllerClass, Class<BossResource> resourceType) {
        super(controllerClass, resourceType);
    }

    @Override
    public BossResource toModel(Boss entity) {
        return  createModelWithId(entity.getId(),entity);
    }

    @Override
    protected BossResource instantiateModel(Boss boss) {
        return new BossResource(boss);
    }

}
