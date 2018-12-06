package by.ivc.okscertificate.web.rest;


import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.CertificateTypeDTO;
import by.ivc.okscertificate.service.CertificateTypeService;
import by.ivc.okscertificate.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "certificate/type")
public class CertificateTypeRestController {

    private final CertificateTypeService typeService;
    private final ValidationService validationService;

    @Autowired
    public CertificateTypeRestController(CertificateTypeService typeService, ValidationService validationService) {
        this.typeService = typeService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String certificateTypeDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(certificateTypeDTOString, SchemaType.CertificateType);
        CertificateTypeDTO certificateTypeDTO = JsonStringToObjectConverter.convert(certificateTypeDTOString, CertificateTypeDTO.class);
        return new ResponseEntity<>(typeService.save(certificateTypeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<CertificateTypeDTO> findAll(){
        return typeService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public CertificateTypeDTO findById(@PathVariable(name="id") Long id){
        return typeService.findById(id);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<CertificateTypeDTO> findByName(@PathVariable(name = "name") String name){
        return typeService.findByName(name);
    }
}
