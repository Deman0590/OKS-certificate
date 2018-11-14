package by.ivc.okscertificate.web.rest;

import by.ivc.okscertificate.data.entity.ServiceType;
import by.ivc.okscertificate.service.ServiceTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "service/type")
public class ServiceTypeRestController {


    private final ServiceTypeService serviceTypeService;

    @Autowired
    public ServiceTypeRestController(ServiceTypeService serviceTypeService) {
        this.serviceTypeService = serviceTypeService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody ServiceType serviceType){
        return new ResponseEntity<>(this.serviceTypeService.save(serviceType), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        serviceTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<ServiceType> findByName(@PathVariable(name = "name") String name){
        return serviceTypeService.findByName(name);
    }

    @RequestMapping(path = "working/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<ServiceType> findByName(@PathVariable(name = "id") Long id){
        return serviceTypeService.findByWorkingTypeId(id);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ServiceType findById(@PathVariable(name="id") Long id){
        return serviceTypeService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<ServiceType> findAll(){
        return serviceTypeService.findAll();
    }
}
