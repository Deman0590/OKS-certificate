package by.ivc.okssertificate.web.rest;

import by.ivc.okssertificate.data.entity.Specialization;
import by.ivc.okssertificate.service.SpecializationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "specialization")
public class SpecializationRestController {

    private final SpecializationService specializationService;

    @Autowired
    public SpecializationRestController(SpecializationService specializationService) {
        this.specializationService = specializationService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody Specialization certificateType){
        return new ResponseEntity<>(specializationService.save(certificateType), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        specializationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Specialization> findAll(){
        return specializationService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Specialization findById(@PathVariable(name="id") Long id){
        return specializationService.findById(id);
    }

    @RequestMapping(path = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Specialization> findByName(@PathVariable(name = "name") String name){
        return specializationService.findByName(name);
    }
}
