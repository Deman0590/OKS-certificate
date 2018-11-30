package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Function;
import by.ivc.okscertificate.data.mapper.FunctionMapper;
import by.ivc.okscertificate.dto.FunctionDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.FunctionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class FunctionServiceImpl implements FunctionService {

    private final BaseMapper baseMapper;
    private final FunctionMapper functionMapper;

    @Autowired
    public FunctionServiceImpl(FunctionMapper functionMapper, BaseMapper baseMapper) {
        this.functionMapper = functionMapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<FunctionDTO> findAll() {
        return baseMapper.mapAll(functionMapper.readAll(), FunctionDTO.class);
    }

    @Override
    public List<FunctionDTO> findByName(String name) {
        return baseMapper.mapAll(functionMapper.readByName(name), FunctionDTO.class);
    }

    @Override
    public List<FunctionDTO> findBySpecializationId(long id) {
        return baseMapper.mapAll(functionMapper.readBySpecializationId(id), FunctionDTO.class);
    }

    @Override
    public FunctionDTO findById(long id) {
        return baseMapper.map(functionMapper.readById(id), FunctionDTO.class);
    }

    @Override
    public long save(FunctionDTO functionDTO) {
        Function function = baseMapper.map(functionDTO, Function.class);
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
