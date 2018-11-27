package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.ServiceType;

import java.util.List;

public interface ServiceTypeService {

    List<ServiceType> findAll();

    List<ServiceType> findByName(String name);

    List<ServiceType> findByWorkingTypeId(long id);

    ServiceType findById(long id);

    long save(ServiceType serviceType);

    void delete(Long id);
}
