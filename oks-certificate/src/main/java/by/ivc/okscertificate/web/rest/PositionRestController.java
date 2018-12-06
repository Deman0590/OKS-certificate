package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.PositionDTO;
import by.ivc.okscertificate.service.PositionService;
import by.ivc.okscertificate.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "position")
public class PositionRestController {

    private final PositionService positionService;
    private final ValidationService validationService;

    @Autowired
    public PositionRestController(PositionService positionService, ValidationService validationService) {
        this.positionService = positionService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String positionDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(positionDTOString, SchemaType.Position);
        PositionDTO positionDTO = JsonStringToObjectConverter.convert(positionDTOString, PositionDTO.class);
        return new ResponseEntity<>(positionService.save(positionDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        positionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<PositionDTO> findByName(@PathVariable(name = "name") String name){
        return positionService.findByName(name);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public PositionDTO findById(@PathVariable(name="id") Long id){
        return positionService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<PositionDTO> findAll(){
        return positionService.findAll();
    }
}
