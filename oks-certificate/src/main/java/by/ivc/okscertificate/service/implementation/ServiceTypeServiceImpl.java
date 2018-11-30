package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.ServiceType;
import by.ivc.okscertificate.data.mapper.ServiceTypeMapper;
import by.ivc.okscertificate.dto.ServiceTypeDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    private final BaseMapper baseMapper;
    private final ServiceTypeMapper serviceTypeMapper;

    @Autowired
    public ServiceTypeServiceImpl(ServiceTypeMapper serviceTypeMapper, BaseMapper baseMapper) {
        this.serviceTypeMapper = serviceTypeMapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<ServiceTypeDTO> findAll() {
        return baseMapper.mapAll(serviceTypeMapper.readAll(), ServiceTypeDTO.class);
    }

    @Override
    public List<ServiceTypeDTO> findByName(String name) {
        return baseMapper.mapAll(serviceTypeMapper.readByName(name), ServiceTypeDTO.class);
    }

    @Override
    public List<ServiceTypeDTO> findByWorkingTypeId(long id) {
        return baseMapper.mapAll(serviceTypeMapper.readByWorkingTypeId(id), ServiceTypeDTO.class);
    }

    @Override
    public ServiceTypeDTO findById(long id) {
        return baseMapper.map(serviceTypeMapper.readById(id), ServiceTypeDTO.class);
    }

    @Override
    public long save(ServiceTypeDTO serviceTypeDTO) {
        ServiceType serviceType = baseMapper.map(serviceTypeDTO, ServiceType.class);
        if (null == serviceType.getId()){
            serviceTypeMapper.create(serviceType);
        } else {
            serviceTypeMapper.update(serviceType);
        }
        return serviceType.getId();
    }

    @Override
    public void delete(Long id) {
        serviceTypeMapper.delete(id);
    }
}
