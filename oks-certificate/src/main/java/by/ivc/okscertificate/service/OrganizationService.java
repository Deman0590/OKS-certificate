package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.Organization;

import java.util.List;

public interface OrganizationService {

    List<Organization> findAll();

    List<Organization> findByName(String name);

    Organization findById(long id);

    long save(Organization organization);

    void delete(Long id);
}
