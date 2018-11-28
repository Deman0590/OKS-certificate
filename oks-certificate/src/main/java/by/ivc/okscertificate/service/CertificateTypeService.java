package by.ivc.okscertificate.service;

import by.ivc.okscertificate.data.entity.CertificateType;
import by.ivc.okscertificate.dto.CertificateTypeDTO;

import java.util.List;

public interface CertificateTypeService {
    List<CertificateTypeDTO> findAll();

    List<CertificateTypeDTO> findByName(String name);

    CertificateTypeDTO findById(long id);

    long save(CertificateTypeDTO certificateTypeDTO);

    void delete(Long id);
}
