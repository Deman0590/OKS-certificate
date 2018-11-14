package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Specialization;
import by.ivc.okscertificate.data.mapper.SpecializationMapper;
import by.ivc.okscertificate.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SpecializationServiceImpl implements SpecializationService {

    @Autowired
    private SpecializationMapper specializationMapper;

    @Override
    public List<Specialization> findAll() {
        return specializationMapper.readAll();
    }

    @Override
    public List<Specialization> findByName(String name) {
        return specializationMapper.readByName(name);
    }

    @Override
    public Specialization findById(long id) {
        return specializationMapper.readById(id);
    }

    @Override
    public long save(Specialization specialization) {
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
