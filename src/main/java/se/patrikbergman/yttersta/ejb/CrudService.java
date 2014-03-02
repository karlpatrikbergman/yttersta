package se.patrikbergman.yttersta.ejb;

public interface CrudService<T> {
    public T create(T t);
    public T find(Class type,Object id);
    public T update(T t);
    public void delete(Class type,Object id);
}