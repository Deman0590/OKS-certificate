package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.Function;
import by.ivc.okscertificate.data.entity.QualificationCertificate;
import by.ivc.okscertificate.data.mapper.QualificationCertificateMapper;
import by.ivc.okscertificate.dto.QualificationCertificateDTO;
import by.ivc.okscertificate.dto.mapper.BaseMapper;
import by.ivc.okscertificate.service.QualificationCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class QualificationCertificateServiceImpl implements QualificationCertificateService {

    private final BaseMapper baseMapper;
    private final QualificationCertificateMapper mapper;

    @Autowired
    public QualificationCertificateServiceImpl(QualificationCertificateMapper mapper, BaseMapper baseMapper) {
        this.mapper = mapper;
        this.baseMapper = baseMapper;
    }

    @Override
    public List<QualificationCertificateDTO> findAll() {
        List<QualificationCertificate> certificates = mapper.readAll();
        return baseMapper.mapAll(mapper.readAll(), QualificationCertificateDTO.class);
    }

    @Override
    public QualificationCertificateDTO findById(long id) {
        return baseMapper.map(mapper.readById(id), QualificationCertificateDTO.class);
    }

    @Override
    public long save(QualificationCertificateDTO qualificationCertificateDTO) {
        QualificationCertificate qualificationCertificate = baseMapper.map(qualificationCertificateDTO, QualificationCertificate.class);
        if (null == qualificationCertificate.getId()){
            mapper.create(qualificationCertificate);
            for (Function function: qualificationCertificate.getFunctions()) {
                mapper.addFunction(qualificationCertificate.getId(), function.getId());
            }
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
