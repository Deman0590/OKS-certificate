package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.ComplianceCertificate;
import by.ivc.okscertificate.data.mapper.ComplianceCertificateMapper;
import by.ivc.okscertificate.service.ComplianceCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ComplianceCertificateImpl implements ComplianceCertificateService {

    @Autowired
    private ComplianceCertificateMapper complianceCertificateMapper;

    @Override
    public List<ComplianceCertificate> findAll(){return complianceCertificateMapper.readAll();}

    @Override
    public ComplianceCertificate findById(long id) { return complianceCertificateMapper.readById(id);}

    @Override
    public long save(ComplianceCertificate complianceCertificate) {
        if (null == complianceCertificate.getId()){
            complianceCertificateMapper.create(complianceCertificate);
        } else {
            complianceCertificateMapper.update(complianceCertificate);
        }
        return complianceCertificate.getId();
    }

    @Override
    public void delete(Long id) { complianceCertificateMapper.delete(id);

    }


}
