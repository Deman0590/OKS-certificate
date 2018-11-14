package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.ServiceType;
import by.ivc.okscertificate.data.mapper.ServiceTypeMapper;
import by.ivc.okscertificate.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServiceTypeServiceImpl implements ServiceTypeService {

    @Autowired
    private ServiceTypeMapper serviceTypeMapper;

    @Override
    public List<ServiceType> findAll() {
        return serviceTypeMapper.readAll();
    }

    @Override
    public List<ServiceType> findByName(String name) {
        return serviceTypeMapper.readByName(name);
    }

    @Override
    public List<ServiceType> findByWorkingTypeId(long id) {
        return serviceTypeMapper.readByWorkingTypeId(id);
    }

    @Override
    public ServiceType findById(long id) {
        return serviceTypeMapper.readById(id);
    }

    @Override
    public long save(ServiceType serviceType) {
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
