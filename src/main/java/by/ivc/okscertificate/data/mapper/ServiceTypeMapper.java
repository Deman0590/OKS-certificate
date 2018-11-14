package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.ServiceType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ServiceTypeMapper extends ReadMapper<Long, ServiceType> {

    List<ServiceType> readByWorkingTypeId(Long id);
}
