package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Position;
import by.ivc.okscertificate.data.mapper.PositionMapper;
import by.ivc.okscertificate.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final PositionMapper mapper;

    @Autowired
    public PositionServiceImpl(PositionMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public List<Position> findAll() {
        return mapper.readAll();
    }

    @Override
    public List<Position> findByName(String name) {
        return mapper.readByName(name);
    }

    @Override
    public Position findById(long id) {
        return mapper.readById(id);
    }

    @Override
    public long save(Position position) {
        if (null == position.getId()){
            mapper.create(position);
        } else {
            mapper.update(position);
        }
        return position.getId();
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }
}
