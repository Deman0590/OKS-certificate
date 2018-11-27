package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.Position;

import java.util.List;

public interface PositionService {

    List<Position> findAll();

    List<Position> findByName(String name);

    Position findById(long id);

    long save(Position position);

    void delete(Long id);
}
