package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.Specialization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpecializationMapper extends ReadMapper<Long, Specialization> {
}
