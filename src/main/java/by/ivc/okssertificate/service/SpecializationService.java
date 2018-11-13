package by.ivc.okssertificate.service;

import by.ivc.okssertificate.data.entity.Specialization;

import java.util.List;

public interface SpecializationService {

    List<Specialization> findAll();

    List<Specialization> findByName(String name);

    Specialization findById(long id);

    long save(Specialization specialization);

    void delete(Long id);
}
