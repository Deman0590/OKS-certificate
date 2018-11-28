package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.ServiceType;
import by.ivc.okscertificate.dto.ServiceTypeDTO;

import java.util.List;

public interface ServiceTypeService {

    List<ServiceTypeDTO> findAll();

    List<ServiceTypeDTO> findByName(String name);

    List<ServiceTypeDTO> findByWorkingTypeId(long id);

    ServiceTypeDTO findById(long id);

    long save(ServiceTypeDTO serviceTypeDTO);

    void delete(Long id);
}
