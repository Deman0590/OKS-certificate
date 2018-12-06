package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.QualificationCertificateDTO;
import by.ivc.okscertificate.service.QualificationCertificateService;
import by.ivc.okscertificate.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "certificate/qualification")
public class QualificationCertificateRestController {

    private final QualificationCertificateService service;
    private final ValidationService validationService;

    @Autowired
    public QualificationCertificateRestController(QualificationCertificateService service, ValidationService validationService) {
        this.service = service;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity save(@RequestBody String certificateDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(certificateDTOString, SchemaType.QualificationCertificate);
        QualificationCertificateDTO certificateDTO = JsonStringToObjectConverter.convert(certificateDTOString, QualificationCertificateDTO.class);
        return new ResponseEntity<>(service.save(certificateDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public QualificationCertificateDTO findById(@PathVariable(name = "id") Long id) {

        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<QualificationCertificateDTO> findAll() {
        return service.findAll();
    }

    @PostMapping(path = "/function", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity addFunction(@RequestParam(name = "certificate") Long certificate,
                                      @RequestParam(name = "function") Long function) {
        service.addFunction(certificate, function);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/function", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteFunction(@RequestParam(name = "certificate") Long certificate,
                                               @RequestParam(name = "function") Long function) {
        service.deleteFunction(certificate, function);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
