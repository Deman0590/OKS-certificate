package by.ivc.okssertificate.service;

import by.ivc.okssertificate.data.entity.WorkingType;

import java.util.List;

public interface WorkingTypeService {
    List<WorkingType> findAll();

    List<WorkingType> findByName(String name);

    WorkingType findById(long id);

    long save(WorkingType workingType);

    void delete(Long id);
}
