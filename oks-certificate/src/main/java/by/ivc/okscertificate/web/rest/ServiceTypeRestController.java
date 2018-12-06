package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.ServiceTypeDTO;
import by.ivc.okscertificate.service.ServiceTypeService;
import by.ivc.okscertificate.service.ValidationService;
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
    private final ValidationService validationService;

    @Autowired
    public ServiceTypeRestController(ServiceTypeService serviceTypeService, ValidationService validationService) {
        this.serviceTypeService = serviceTypeService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String serviceTypeDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(serviceTypeDTOString, SchemaType.ServiceType);
        ServiceTypeDTO serviceTypeDTO = JsonStringToObjectConverter.convert(serviceTypeDTOString, ServiceTypeDTO.class);
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
