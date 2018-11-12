package by.ivc.okssertificate.data.mapper;

import by.ivc.okssertificate.data.entity.CertificateType;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface CertificateTypeMapper extends CrudMapper<Long, CertificateType> {

    CertificateType readById(Long id);

    List<CertificateType> readByName(String name);

    List<CertificateType> readAll();
}
