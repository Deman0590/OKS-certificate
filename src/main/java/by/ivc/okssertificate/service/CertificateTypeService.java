package by.ivc.okssertificate.service;

import by.ivc.okssertificate.data.entity.CertificateType;

import java.util.List;

public interface CertificateTypeService {
    List<CertificateType> findAll();

    List<CertificateType> findByName(String name);

    CertificateType findById(long id);

    long save(CertificateType certificateType);

    void delete(Long id);
}
