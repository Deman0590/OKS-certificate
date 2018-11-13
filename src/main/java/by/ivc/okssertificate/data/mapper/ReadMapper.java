package by.ivc.okssertificate.data.mapper;

import java.util.List;

public interface ReadMapper<ID, T> extends CrudMapper<ID, T> {

    T readById(ID id);

    List<T> readByName(String name);

    List<T> readAll();
}
