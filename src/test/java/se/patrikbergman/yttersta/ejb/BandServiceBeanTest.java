package se.patrikbergman.yttersta.ejb;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import se.patrikbergman.yttersta.entity.BandEntity;

import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class BandServiceBeanTest {

    private BandServiceBean bandServiceBean;
    private EntityTransaction transaction;

    @Before
    public void before() {
        bandServiceBean = new BandServiceBean();
        bandServiceBean.em = Persistence.createEntityManagerFactory("yttersta-pu-test").createEntityManager();
        this.transaction = bandServiceBean.em.getTransaction();
    }

    //@Test
    public void createBand() {
        try {
            BandEntity bandEntity = new BandEntity();
            bandEntity.setName("Judas Priest");
            bandEntity.setDescription("Some description");
            transaction.begin();
            BandEntity result = bandServiceBean.create(bandEntity);
            transaction.commit();
            assertNotNull(result);
            System.out.println(result);
        } catch (Exception e) {
            transaction.rollback();
            fail(e.getMessage());
        }
    }

    @Test
    public void findBand() {
        try {
            transaction.begin();
            BandEntity result = bandServiceBean.find(BandEntity.class, new Integer(1));
            transaction.commit();
            assertNotNull(result);
            System.out.println(result);
        } catch (Exception e) {
            transaction.rollback();
            fail(e.getMessage());
        }
    }

    @Test
    public void findBands() {
        try {
            transaction.begin();
            List<BandEntity> result = bandServiceBean.findAll();
            transaction.commit();
            assertNotNull(result);
            System.out.println(result);
        } catch (Exception e) {
            transaction.rollback();
            fail(e.getMessage());
        }
    }

    @After
    public void after() {
        bandServiceBean = null;
    }
}
