package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.FunctionDTO;
import by.ivc.okscertificate.service.FunctionService;
import by.ivc.okscertificate.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "function")
public class FunctionRestController {

    private final FunctionService functionService;
    private final ValidationService validationService;

    @Autowired
    public FunctionRestController(FunctionService functionService, ValidationService validationService) {
        this.functionService = functionService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String functionDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(functionDTOString, SchemaType.Function);
        FunctionDTO functionDTO = JsonStringToObjectConverter.convert(functionDTOString, FunctionDTO.class);
        return new ResponseEntity<>(functionService.save(functionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        functionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<FunctionDTO> findByName(@PathVariable(name = "name") String name){
        return functionService.findByName(name);
    }

    @GetMapping(path = "specialization/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<FunctionDTO> findBySpecializationId(@PathVariable(name = "id") Long id){
        return functionService.findBySpecializationId(id);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public FunctionDTO findById(@PathVariable(name="id") Long id){
        return functionService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<FunctionDTO> findAll(){
        return functionService.findAll();
    }
}
