package by.ivc.okscertificate.web.rest;

import by.ivc.okscertificate.data.entity.ServiceType;
import by.ivc.okscertificate.dto.ServiceTypeDTO;
import by.ivc.okscertificate.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "service/type")
public class ServiceTypeRestController {


    private final ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceTypeRestController(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody ServiceTypeDTO serviceTypeDTO){
        return new ResponseEntity<>(this.serviceTypeService.save(serviceTypeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        serviceTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<ServiceTypeDTO> findByName(@PathVariable(name = "name") String name){
        return serviceTypeService.findByName(name);
    }

    @GetMapping(path = "working/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<ServiceTypeDTO> findByName(@PathVariable(name = "id") Long id){
        return serviceTypeService.findByWorkingTypeId(id);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ServiceTypeDTO findById(@PathVariable(name="id") Long id){
        return serviceTypeService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<ServiceTypeDTO> findAll(){
        return serviceTypeService.findAll();
    }
}
