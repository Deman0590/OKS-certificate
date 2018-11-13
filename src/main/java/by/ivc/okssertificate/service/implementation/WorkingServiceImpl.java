package by.ivc.okssertificate.service.implementation;

import by.ivc.okssertificate.data.entity.WorkingType;
import by.ivc.okssertificate.data.mapper.WorkingTypeMapper;
import by.ivc.okssertificate.service.WorkingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class WorkingServiceImpl implements WorkingTypeService {

    @Autowired
    private WorkingTypeMapper workingTypeMapper;

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
