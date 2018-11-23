package by.ivc.okscertificate.service;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface FileService {

    Resource loadFile(long id);

    long save(MultipartFile file);

    void delete(Long id);
}
