package se.patrikbergman.yttersta.ejb;

import se.patrikbergman.yttersta.entity.BandEntity;

import javax.ejb.*;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;

@Stateless
@Remote(CrudService.class)
@Path("/band")
public class BandServiceBean extends CrudServiceBean<BandEntity> {

    public BandServiceBean() {}

    @GET
    @Path("/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public String hello(@PathParam("id") int id) {
        return "Hello";
    }

}
