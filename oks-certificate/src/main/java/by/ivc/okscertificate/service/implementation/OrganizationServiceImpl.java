package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Organization;
import by.ivc.okscertificate.data.mapper.OrganizationMapper;
import by.ivc.okscertificate.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationMapper organizationMapper) {
        this.organizationMapper = organizationMapper;
    }

    @Override
    public List<Organization> findAll() {
        return organizationMapper.readAll();
    }

    @Override
    public List<Organization> findByName(String name) {
        return organizationMapper.readByName(name);
    }

    @Override
    public Organization findById(long id) {
        return organizationMapper.readById(id);
    }

    @Override
    public long save(Organization organization) {
        if (null == organization.getId()){
            organizationMapper.create(organization);
        } else {
            organizationMapper.update(organization);
        }
        return organization.getId();
    }

    @Override
    public void delete(Long id) {
        organizationMapper.delete(id);
    }
}
