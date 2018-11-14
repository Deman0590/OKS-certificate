package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.CertificateType;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CertificateTypeMapper extends ReadMapper<Long, CertificateType> {}
