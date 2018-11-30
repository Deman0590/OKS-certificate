package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.WorkingType;
import by.ivc.okscertificate.dto.WorkingTypeDTO;

import java.util.List;

public interface WorkingTypeService {
    List<WorkingTypeDTO> findAll();

    List<WorkingTypeDTO> findByName(String name);

    WorkingTypeDTO findById(long id);

    long save(WorkingTypeDTO workingTypeDTO);

    void delete(Long id);
}
