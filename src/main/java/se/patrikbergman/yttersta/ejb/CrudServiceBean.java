package se.patrikbergman.yttersta.ejb;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

abstract class CrudServiceBean<T> implements CrudService<T> {

    @PersistenceContext
    EntityManager em;

    @Override
    public  T create(T t) {
        this.em.persist(t);
        this.em.flush();
        this.em.refresh(t);
        return t;
    }

    @Override
    public  T find(Class type,Object id) {
        return (T) this.em.find(type, id);
    }

    @Override
    public void delete(Class type,Object id) {
        Object ref = this.em.getReference(type, id);
        this.em.remove(ref);
    }

    @Override
    public  T update(T t) {
        return (T)this.em.merge(t);
    }
}

