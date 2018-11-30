package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.CertificateType;
import by.ivc.okscertificate.data.mapper.CertificateTypeMapper;
import by.ivc.okscertificate.dto.CertificateTypeDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.CertificateTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CertificateTypeServiceImpl implements CertificateTypeService {

    private final BaseMapper baseMapper;
    private final CertificateTypeMapper typeMapper;

    @Autowired
    public CertificateTypeServiceImpl(CertificateTypeMapper typeMapper, BaseMapper baseMapper) {
        this.typeMapper = typeMapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<CertificateTypeDTO> findAll() {
        return baseMapper.mapAll(typeMapper.readAll(),CertificateTypeDTO.class);
    }

    @Override
    public List<CertificateTypeDTO> findByName(String name) {
        return baseMapper.mapAll(typeMapper.readByName(name), CertificateTypeDTO.class);
    }

    @Override
    public CertificateTypeDTO findById(long id) {
        return baseMapper.map(typeMapper.readById(id),CertificateTypeDTO.class);
    }

    @Override
    public long save(CertificateTypeDTO certificateTypeDTO) {
        CertificateType certificateType = baseMapper.map(certificateTypeDTO, CertificateType.class);
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
