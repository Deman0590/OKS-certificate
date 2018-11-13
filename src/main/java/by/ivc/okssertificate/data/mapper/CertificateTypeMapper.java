package by.ivc.okssertificate.data.mapper;

import by.ivc.okssertificate.data.entity.CertificateType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateTypeMapper extends ReadMapper<Long, CertificateType> {}
