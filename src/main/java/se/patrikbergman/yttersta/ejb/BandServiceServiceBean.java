package se.patrikbergman.yttersta.ejb;

import se.patrikbergman.yttersta.entity.BandEntity;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;

@Stateless
@Remote(CrudService.class)
@TransactionAttribute(TransactionAttributeType.MANDATORY)
@Path("band")
public class BandServiceServiceBean extends CrudServiceBean<BandEntity> {


    @GET
    @Produces("text/html")
    public String hello() {
        return "Hello";
    }

}
