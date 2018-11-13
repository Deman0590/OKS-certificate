package by.ivc.okssertificate.data.mapper;

import by.ivc.okssertificate.data.entity.Specialization;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface SpecializationMapper extends ReadMapper<Long, Specialization> {
}
