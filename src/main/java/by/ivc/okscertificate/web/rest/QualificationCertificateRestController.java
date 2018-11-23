package by.ivc.okscertificate.web.rest;

import by.ivc.okscertificate.data.entity.QualificationCertificate;
import by.ivc.okscertificate.service.QualificationCertificateService;
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

    @Autowired
    public QualificationCertificateRestController(QualificationCertificateService service) {
        this.service = service;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity save(@RequestBody QualificationCertificate certificate){
        return new ResponseEntity<>(service.save(certificate), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public QualificationCertificate findById(@PathVariable(name="id") Long id){

        return service.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<QualificationCertificate> findAll(){
        return service.findAll();
    }

    @PostMapping(path= "/function", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity addFunction(@RequestParam(name="certificate") Long certificate,
                                      @RequestParam(name = "function") Long function){
        service.addFunction(certificate, function);
        return new ResponseEntity<>(HttpStatus.CREATED);
    }

    @DeleteMapping(path= "/function", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity<Void> deleteFunction(@RequestParam(name="certificate") Long certificate,
                                               @RequestParam(name = "function") Long function){
        service.deleteFunction(certificate, function);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
