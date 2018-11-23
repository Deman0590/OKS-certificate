package by.ivc.okscertificate.data.mapper;

import by.ivc.okscertificate.data.entity.File;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface FileMapper {

    File readById(Long id);

    Long create(File o);

    void delete(Long id);
}
