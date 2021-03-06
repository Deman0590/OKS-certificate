package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.WorkingTypeDTO;
import by.ivc.okscertificate.service.ValidationService;
import by.ivc.okscertificate.service.WorkingTypeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/working/type")
public class WorkingTypeRestController {

    private final WorkingTypeService workingTypeService;
    private final ValidationService validationService;

    @Autowired
    public WorkingTypeRestController(WorkingTypeService workingTypeService, ValidationService validationService) {
        this.workingTypeService = workingTypeService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String workingTypeDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(workingTypeDTOString, SchemaType.WorkingType);
        WorkingTypeDTO workingTypeDTO = JsonStringToObjectConverter.convert(workingTypeDTOString, WorkingTypeDTO.class);
        return new ResponseEntity<>(workingTypeService.save(workingTypeDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        workingTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<WorkingTypeDTO> findAll() {
        return workingTypeService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public WorkingTypeDTO findById(@PathVariable(name = "id") Long id) {
        return workingTypeService.findById(id);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<WorkingTypeDTO> findByName(@PathVariable(name = "name") String name) {
        return workingTypeService.findByName(name);
    }
}
