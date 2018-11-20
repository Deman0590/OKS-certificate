package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.QualificationCertificate;

import java.util.List;

public interface QualificationCertificateService {

    List<QualificationCertificate> findAll();

    QualificationCertificate findById(long id);

    long save(QualificationCertificate qualificationCertificate);

    void delete(Long id);

    void addFunction(Long certificate, Long function);

    void deleteFunction(Long certificate, Long function);
}
