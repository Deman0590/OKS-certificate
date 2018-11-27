package by.ivc.okscertificate.dto.mapper;

import by.ivc.okscertificate.data.entity.Function;
import by.ivc.okscertificate.data.entity.QualificationCertificate;
import by.ivc.okscertificate.data.entity.ServiceType;
import by.ivc.okscertificate.dto.FunctionDTO;
import by.ivc.okscertificate.dto.QualificationCertificateDTO;
import by.ivc.okscertificate.dto.ServiceTypeDTO;

public class BaseFactoryMapper implements FactoryMapper {

    @Override
    public AbstractMapper getMapper(Object object){
        if (object instanceof QualificationCertificate || object instanceof QualificationCertificateDTO){
            return new QualificationCertificateMapper();
        } else if (object instanceof Function || object instanceof FunctionDTO) {
            return new FunctionMapper();
        } else if (object instanceof ServiceType || object instanceof ServiceTypeDTO) {
            return new ServiceTypeMapper();
        } else {
            return new BaseMapper();
        }
    }
}
