package by.ivc.okssertificate.service;

import by.ivc.okssertificate.data.entity.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> findAll();

    List<Organization> findByName(String name);

    Organization findById(long id);

    long save(Organization organization);

    void delete(Long id);
}
