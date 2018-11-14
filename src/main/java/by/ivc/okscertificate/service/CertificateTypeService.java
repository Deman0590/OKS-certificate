package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.CertificateType;

import java.util.List;

public interface CertificateTypeService {
    List<CertificateType> findAll();

    List<CertificateType> findByName(String name);

    CertificateType findById(long id);

    long save(CertificateType certificateType);

    void delete(Long id);
}
