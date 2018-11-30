package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Specialization;
import by.ivc.okscertificate.data.mapper.SpecializationMapper;
import by.ivc.okscertificate.dto.SpecializationDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    private final BaseMapper baseMapper;
    private final SpecializationMapper specializationMapper;

    @Autowired
    public SpecializationServiceImpl(SpecializationMapper specializationMapper, BaseMapper baseMapper) {
        this.specializationMapper = specializationMapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<SpecializationDTO> findAll() {
        return baseMapper.mapAll(specializationMapper.readAll(), SpecializationDTO.class);
    }

    @Override
    public List<SpecializationDTO> findByName(String name) {
        return baseMapper.mapAll(specializationMapper.readByName(name), SpecializationDTO.class);
    }

    @Override
    public SpecializationDTO findById(long id) {
        return baseMapper.map(specializationMapper.readById(id), SpecializationDTO.class);
    }

    @Override
    public long save(SpecializationDTO specializationDTO) {
        Specialization specialization = baseMapper.map(specializationDTO, Specialization.class);
        if (null == specialization.getId()){
            specializationMapper.create(specialization);
        } else {
            specializationMapper.update(specialization);
        }
        return specialization.getId();
    }

    @Override
    public void delete(Long id) {
        specializationMapper.delete(id);
    }
}
