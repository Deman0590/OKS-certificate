package by.ivc.okscertificate.dto.mapper;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.ArrayList;
import java.util.List;

public class BaseMapper {

    @Autowired
    private ModelMapper modelMapper;

    public <D,S> D map(S source, Class<D> outClass) {
        if (null != source) {
            return modelMapper.map(source, outClass);
        }
        return null;
    }

    public <D,S> List<D> mapAll(List<S> sourceList, Class<D> outClass) {
        if (null != sourceList) {
            List<D> destinationList = new ArrayList<>();
            for (S source : sourceList) {
                destinationList.add(modelMapper.map(source, outClass));
            }
            return destinationList;
        }
        return null;
    }
}
