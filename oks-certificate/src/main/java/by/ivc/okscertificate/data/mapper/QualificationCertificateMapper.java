package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.QualificationCertificate;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface QualificationCertificateMapper extends CrudMapper<Long, QualificationCertificate> {

    QualificationCertificate readById(Long id);

    List<QualificationCertificate> readAll();

    void addFunction(@Param("certificate") Long certificate, @Param("function") Long function);

    void deleteFunction(@Param("certificate") Long certificate, @Param("function") Long function);
}
