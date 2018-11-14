package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.Function;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface FunctionMapper extends ReadMapper<Long, Function> {

    List<Function> readBySpecializationId(Long id);
}
