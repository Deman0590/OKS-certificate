package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.Specialization;
import by.ivc.okscertificate.dto.SpecializationDTO;

import java.util.List;

public interface SpecializationService {

    List<SpecializationDTO> findAll();

    List<SpecializationDTO> findByName(String name);

    SpecializationDTO findById(long id);

    long save(SpecializationDTO specializationDTO);

    void delete(Long id);
}
