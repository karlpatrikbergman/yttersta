package se.patrikbergman.yttersta.ejb;

import se.patrikbergman.yttersta.entity.BandEntity;

import javax.ejb.*;
import javax.persistence.Query;
import javax.persistence.TypedQuery;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import java.util.List;

@Stateless
@Path("/band")
public class BandServiceBean extends CrudServiceBean<BandEntity> {

    public BandServiceBean() {}

    @GET
    @Path("/hello/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public BandEntity hello(@PathParam("id") int id) {
        BandEntity band = new BandEntity();
        band.setId(id);
        band.setName("test");
        band.setDescription("teset");
        return band;
    }

    @GET
    @Path("/find/{id:[0-9][0-9]*}")
    @Produces("application/json")
    public BandEntity find(@PathParam("id") int id) {
        return find(BandEntity.class, new Integer(id));
    }

    @GET
    @Path("find/all")
    @Produces("application/json")
    public List<BandEntity> findAll() {
        TypedQuery<BandEntity> queryFindAllBands = em.createNamedQuery("Band.findAllBands", BandEntity.class);
        List<BandEntity> bands = queryFindAllBands.getResultList();
        return bands;
    }
}
