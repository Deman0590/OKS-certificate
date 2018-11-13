package by.ivc.okssertificate.service.implementation;

import by.ivc.okssertificate.data.entity.Organization;
import by.ivc.okssertificate.data.mapper.OrganizationMapper;
import by.ivc.okssertificate.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    @Autowired
    private OrganizationMapper organizationMapper;

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
