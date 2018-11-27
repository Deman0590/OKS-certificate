package by.ivc.okscertificate.web.rest;


import by.ivc.okscertificate.data.entity.ComplianceCertificate;
import by.ivc.okscertificate.service.ComplianceCertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "certificate/compliance")
public class ComplianceCertificateRestController {

    private final ComplianceCertificateService service;

    @Autowired
    public ComplianceCertificateRestController(ComplianceCertificateService service) {
        this.service = service;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity save(@RequestBody ComplianceCertificate certificate) {
        return new ResponseEntity<>(service.save(certificate), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        service.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ComplianceCertificate findById(@PathVariable(name = "id") Long id) {

        return service.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<ComplianceCertificate> findAll() {
        return service.findAll();
    }
}
