package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Position;
import by.ivc.okscertificate.data.mapper.PositionMapper;
import by.ivc.okscertificate.dto.PositionDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.PositionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PositionServiceImpl implements PositionService {

    private final BaseMapper baseMapper;
    private final PositionMapper mapper;

    @Autowired
    public PositionServiceImpl(PositionMapper mapper, BaseMapper baseMapper) {
        this.mapper = mapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<PositionDTO> findAll() {
        return baseMapper.mapAll(mapper.readAll(), PositionDTO.class);
    }

    @Override
    public List<PositionDTO> findByName(String name) {
        return baseMapper.mapAll(mapper.readByName(name), PositionDTO.class);
    }

    @Override
    public PositionDTO findById(long id) {
        return baseMapper.map(mapper.readById(id), PositionDTO.class);
    }

    @Override
    public long save(PositionDTO positionDTO) {
        Position position = baseMapper.map(positionDTO, Position.class);
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
