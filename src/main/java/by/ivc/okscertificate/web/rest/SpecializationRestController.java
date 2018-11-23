package by.ivc.okscertificate.web.rest;

import by.ivc.okscertificate.data.entity.Specialization;
import by.ivc.okscertificate.service.SpecializationService;
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

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody Specialization certificateType){
        return new ResponseEntity<>(specializationService.save(certificateType), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        specializationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Specialization> findAll(){
        return specializationService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Specialization findById(@PathVariable(name="id") Long id){
        return specializationService.findById(id);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Specialization> findByName(@PathVariable(name = "name") String name){
        return specializationService.findByName(name);
    }
}
