package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Function;
import by.ivc.okscertificate.data.mapper.FunctionMapper;
import by.ivc.okscertificate.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    @Autowired
    private FunctionMapper functionMapper;

    @Override
    public List<Function> findAll() {
        return functionMapper.readAll();
    }

    @Override
    public List<Function> findByName(String name) {
        return functionMapper.readByName(name);
    }

    @Override
    public List<Function> findBySpecializationId(long id) {
        return functionMapper.readBySpecializationId(id);
    }

    @Override
    public Function findById(long id) {
        return functionMapper.readById(id);
    }

    @Override
    public long save(Function function) {
        if (null == function.getId()){
            functionMapper.create(function);
        } else {
            functionMapper.update(function);
        }
        return function.getId();
    }

    @Override
    public void delete(Long id) {
        functionMapper.delete(id);
    }
}
