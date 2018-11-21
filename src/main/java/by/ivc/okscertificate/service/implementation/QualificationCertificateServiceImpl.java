package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.QualificationCertificate;
import by.ivc.okscertificate.data.mapper.QualificationCertificateMapper;
import by.ivc.okscertificate.service.QualificationCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationCertificateServiceImpl implements QualificationCertificateService {

    @Autowired
    private QualificationCertificateMapper mapper;

    @Override
    public List<QualificationCertificate> findAll() {
        return mapper.readAll();
    }

    @Override
    public QualificationCertificate findById(long id) {
        return mapper.readById(id);
    }

    @Override
    public long save(QualificationCertificate qualificationCertificate) {
        if (null == qualificationCertificate.getId()){
            mapper.create(qualificationCertificate);
        } else {
            mapper.update(qualificationCertificate);
        }
        return qualificationCertificate.getId();
    }

    @Override
    public void delete(Long id) {
        mapper.delete(id);
    }

    @Override
    public void addFunction(Long certificate, Long function) {
        mapper.addFunction(certificate, function);
    }

    @Override
    public void deleteFunction(Long certificate, Long function) {
        mapper.deleteFunction(certificate, function);
    }
}
