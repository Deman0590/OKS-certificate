package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.WorkingType;
import by.ivc.okscertificate.data.mapper.WorkingTypeMapper;
import by.ivc.okscertificate.dto.WorkingTypeDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.WorkingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkingServiceImpl implements WorkingTypeService {

    private final BaseMapper baseMapper;
    private final WorkingTypeMapper workingTypeMapper;

    @Autowired
    public WorkingServiceImpl(WorkingTypeMapper workingTypeMapper, BaseMapper baseMapper) {
        this.workingTypeMapper = workingTypeMapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<WorkingTypeDTO> findAll() {
        return baseMapper.mapAll(workingTypeMapper.readAll(), WorkingTypeDTO.class);
    }

    @Override
    public List<WorkingTypeDTO> findByName(String name) {
        return baseMapper.mapAll(workingTypeMapper.readByName(name), WorkingTypeDTO.class);
    }

    @Override
    public WorkingTypeDTO findById(long id) {
        return baseMapper.map(workingTypeMapper.readById(id), WorkingTypeDTO.class);
    }

    @Override
    public long save(WorkingTypeDTO workingTypeDTO) {
        WorkingType workingType = baseMapper.map(workingTypeDTO, WorkingType.class);
        if (null == workingType.getId()){
            workingTypeMapper.create(workingType);
        } else {
            workingTypeMapper.update(workingType);
        }
        return workingType.getId();
    }

    @Override
    public void delete(Long id) {
        workingTypeMapper.delete(id);
    }
}
