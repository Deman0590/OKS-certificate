package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.ComplianceCertificate;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

@Mapper
public interface ComplianceCertificateMapper extends CrudMapper<Long, ComplianceCertificate>{

    List<ComplianceCertificate> readAll();

    ComplianceCertificate readById(long id);
}
