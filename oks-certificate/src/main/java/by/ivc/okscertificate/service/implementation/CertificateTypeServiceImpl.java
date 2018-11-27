package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.CertificateType;
import by.ivc.okscertificate.data.mapper.CertificateTypeMapper;
import by.ivc.okscertificate.service.CertificateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateTypeServiceImpl implements CertificateTypeService {

    private final CertificateTypeMapper typeMapper;

    @Autowired
    public CertificateTypeServiceImpl(CertificateTypeMapper typeMapper) {
        this.typeMapper = typeMapper;
    }

    @Override
    public List<CertificateType> findAll() {
        return typeMapper.readAll();
    }

    @Override
    public List<CertificateType> findByName(String name) {
        return typeMapper.readByName(name);
    }

    @Override
    public CertificateType findById(long id) {
        return typeMapper.readById(id);
    }

    @Override
    public long save(CertificateType certificateType) {
        if (null == certificateType.getId()){
            typeMapper.create(certificateType);
        } else {
            typeMapper.update(certificateType);
        }
        return certificateType.getId();
    }

    @Override
    public void delete(Long id) {
        typeMapper.delete(id);
    }
}
