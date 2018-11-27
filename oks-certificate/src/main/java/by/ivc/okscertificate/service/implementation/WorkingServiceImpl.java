package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.WorkingType;
import by.ivc.okscertificate.data.mapper.WorkingTypeMapper;
import by.ivc.okscertificate.service.WorkingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkingServiceImpl implements WorkingTypeService {

    private final WorkingTypeMapper workingTypeMapper;

    @Autowired
    public WorkingServiceImpl(WorkingTypeMapper workingTypeMapper) {
        this.workingTypeMapper = workingTypeMapper;
    }

    @Override
    public List<WorkingType> findAll() {
        return workingTypeMapper.readAll();
    }

    @Override
    public List<WorkingType> findByName(String name) {
        return workingTypeMapper.readByName(name);
    }

    @Override
    public WorkingType findById(long id) {
        return workingTypeMapper.readById(id);
    }

    @Override
    public long save(WorkingType workingType) {
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
