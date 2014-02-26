package se.patrikbergman.yttersta.model;

import org.junit.Before;
import org.junit.Test;
import se.patrikbergman.yttersta.model.entity.BandEntity;

import javax.persistence.EntityManager;
import javax.persistence.Persistence;

public class CrudServiceBeanTest {

    CrudServiceBean crudServiceBean;

    @Before
    public void before() {
        crudServiceBean = new CrudServiceBean<BandEntity>();
        EntityManager em = Persistence.createEntityManagerFactory("yttersta-pu-test").createEntityManager();
    }

    @Test
    public void foo() {
        System.out.println("foo");
    }

}
