package by.ivc.okscertificate.dto.mapper;

import org.modelmapper.ModelMapper;


import java.util.ArrayList;
import java.util.List;

public class BaseMapper<D,S> implements AbstractMapper<D,S> {

    private static ModelMapper modelMapper = new ModelMapper();

    @Override
    public D map(S source, Class<D> outClass) {
        if (null != source) {
            return modelMapper.map(source, outClass);
        }
        return null;
    }

    @Override
    public List<D> mapAll(List<S> sourceList, Class<D> outClass) {
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
