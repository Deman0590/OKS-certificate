package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.Function;
import by.ivc.okscertificate.dto.FunctionDTO;

import java.util.List;

public interface FunctionService {

    List<FunctionDTO> findAll();

    List<FunctionDTO> findByName(String name);

    List<FunctionDTO> findBySpecializationId(long id);

    FunctionDTO findById(long id);

    long save(FunctionDTO functionDTO);

    void delete(Long id);
}
