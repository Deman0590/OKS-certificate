package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.Position;
import by.ivc.okscertificate.dto.PositionDTO;

import java.util.List;

public interface PositionService {

    List<PositionDTO> findAll();

    List<PositionDTO> findByName(String name);

    PositionDTO findById(long id);

    long save(PositionDTO positionDTO);

    void delete(Long id);
}
