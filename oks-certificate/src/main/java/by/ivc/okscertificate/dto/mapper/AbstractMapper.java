package by.ivc.okscertificate.dto.mapper;

import java.util.List;

public interface AbstractMapper<D,S> {

    D map(S source, Class<D> outClass);

    List<D> mapAll(List<S> sourceList, Class<D> outClass);
}
