package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.ComplianceCertificate;

import java.util.List;

public interface ComplianceCertificateService {

    List<ComplianceCertificate> findAll();

    ComplianceCertificate findById(long id);

    long save(ComplianceCertificate complianceCertificate);

    void delete(Long id);

    //List<ComplianceCertificate> findByName(String name);


}
