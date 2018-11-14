package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.Function;

import java.util.List;

public interface FunctionService {

    List<Function> findAll();

    List<Function> findByName(String name);

    List<Function> findBySpecializationId(long id);

    Function findById(long id);

    long save(Function function);

    void delete(Long id);
}
