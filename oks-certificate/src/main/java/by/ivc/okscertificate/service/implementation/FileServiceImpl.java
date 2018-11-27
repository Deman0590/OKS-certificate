package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.File;
import by.ivc.okscertificate.data.mapper.FileMapper;
import by.ivc.okscertificate.service.FileService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

@Service
public class FileServiceImpl implements FileService {

    /*
     * NOT TESTING !!!
     */

    private final FileMapper mapper;
    private final Path fileRootPath = Paths.get("upload-certificate");

    @Autowired
    public FileServiceImpl(FileMapper mapper) {
        this.mapper = mapper;
    }

    @Override
    public Resource loadFile(long id) {
        try {
            File file = mapper.readById(id);
            Path filePath = fileRootPath.resolve(file.getName());
            Resource resource = new UrlResource(filePath.toUri());
            if (resource.exists() || resource.isReadable()) {
                return resource;
            } else {
                throw new RuntimeException("fail loading file");
            }
        } catch (MalformedURLException e) {
            throw new RuntimeException("fail loading file");
        }
    }

    @Override
    public long save(MultipartFile file) {
        try {
            Files.copy(file.getInputStream(), this.fileRootPath.resolve(file.getOriginalFilename()));
            File fileEntity = new File();
            fileEntity.setName(file.getOriginalFilename());
            mapper.create(fileEntity);
            return fileEntity.getId();
        } catch (IOException e) {
            throw new RuntimeException("fail saving file");
        }
    }

    @Override
    public void delete(Long id) {
        File file = mapper.readById(id);
        try {
            Files.deleteIfExists(fileRootPath.resolve(file.getName()));
            mapper.delete(id);
        } catch (IOException e) {
            throw new RuntimeException("fail delete file");
        }
    }

    public void init(){
        /*
        * TODO: check existing file root directory. create if needed
        */
    }
}
