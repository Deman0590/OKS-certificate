package by.ivc.okssertificate.data.mapper;

public interface CrudMapper<ID, T> {

    Long create(T o);

    void update(T o);

    void delete(ID id);
}
