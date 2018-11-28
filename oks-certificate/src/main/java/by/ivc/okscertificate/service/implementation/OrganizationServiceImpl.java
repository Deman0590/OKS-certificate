package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Organization;
import by.ivc.okscertificate.data.mapper.OrganizationMapper;
import by.ivc.okscertificate.dto.OrganizationDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrganizationServiceImpl implements OrganizationService {

    private final BaseMapper baseMapper;
    private final OrganizationMapper organizationMapper;

    @Autowired
    public OrganizationServiceImpl(OrganizationMapper organizationMapper, BaseMapper baseMapper) {
        this.organizationMapper = organizationMapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<OrganizationDTO> findAll() {
        return baseMapper.mapAll(organizationMapper.readAll(), OrganizationDTO.class);
    }

    @Override
    public List<OrganizationDTO> findByName(String name) {
        return baseMapper.mapAll(organizationMapper.readByName(name), OrganizationDTO.class);
    }

    @Override
    public OrganizationDTO findById(long id) {
        return baseMapper.map(organizationMapper.readById(id), OrganizationDTO.class);
    }

    @Override
    public long save(OrganizationDTO organizationDTO) {
        Organization organization = baseMapper.map(organizationDTO, Organization.class);
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
