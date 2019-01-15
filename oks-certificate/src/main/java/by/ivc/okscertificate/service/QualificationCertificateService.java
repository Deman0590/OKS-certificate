package by.ivc.okscertificate.service;

import by.ivc.okscertificate.dto.QualificationCertificateDTO;

import java.util.List;

public interface QualificationCertificateService {

    List<QualificationCertificateDTO> findAll();

    QualificationCertificateDTO findById(long id);

    long save(QualificationCertificateDTO qualificationCertificateDTO);

    void delete(Long id);

    void addFunction(Long certificate, Long function);

    void deleteFunction(Long certificate, Long function);
}
