package by.ivc.okssertificate.web.rest;


import by.ivc.okssertificate.data.entity.CertificateType;
import by.ivc.okssertificate.service.CertificateTypeService;
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

    @Autowired
    public CertificateTypeRestController(CertificateTypeService typeService) {
        this.typeService = typeService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody CertificateType certificateType){
        return new ResponseEntity<>(typeService.save(certificateType), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        typeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<CertificateType> findAll(){
        return typeService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public CertificateType findById(@PathVariable(name="id") Long id){
        return typeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, params = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<CertificateType> findByName(@RequestParam(name = "name") String name){
        return typeService.findByName(name);
    }
}
