package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.Organization;
import by.ivc.okscertificate.dto.OrganizationDTO;

import java.util.List;

public interface OrganizationService {

    List<OrganizationDTO> findAll();

    List<OrganizationDTO> findByName(String name);

    OrganizationDTO findById(long id);

    long save(OrganizationDTO organizationDTO);

    void delete(Long id);
}
