package by.ivc.okscertificate.service.implementation;

import by.ivc.okscertificate.data.entity.File;
import by.ivc.okscertificate.data.mapper.FileMapper;
import by.ivc.okscertificate.service.FileService;
import liquibase.util.file.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.Resource;
import org.springframework.core.io.UrlResource;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.PostConstruct;
import java.io.IOException;
import java.net.MalformedURLException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

@Service
public class FileServiceImpl implements FileService {

    private final FileMapper mapper;
    private final Path fileRootPath = Paths.get(".upload");

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
            String freFileName = freeFileName(file);
            Files.copy(file.getInputStream(), this.fileRootPath.resolve(freFileName));
            File fileEntity = new File();
            fileEntity.setName(freFileName);
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

    @PostConstruct
    public void init() {
        java.io.File baseDir = new java.io.File(fileRootPath.toString());
        if (!baseDir.exists()) {
            baseDir.mkdir();
        }
    }

    private String freeFileName(MultipartFile file) {
        String fileName = file.getOriginalFilename();
        Path filePath = fileRootPath.resolve(fileName);
        if (Files.exists(filePath)) {
            DateFormat dateFormat = new SimpleDateFormat("yyyy.MM.dd_HH.mm.ss");
            fileName = FilenameUtils.getBaseName(file.getOriginalFilename())+ "_" + dateFormat.format(new Date()) + "." + FilenameUtils.getExtension(file.getOriginalFilename());
        }
        return fileName;
    }
}
