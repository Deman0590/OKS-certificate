package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.CertificateTypeDTO;
import by.ivc.okscertificate.dto.SpecializationDTO;
import by.ivc.okscertificate.service.SpecializationService;
import by.ivc.okscertificate.service.ValidationService;
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
    private final ValidationService validationService;

    @Autowired
    public SpecializationRestController(SpecializationService specializationService, ValidationService validationService) {
        this.specializationService = specializationService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String certificateTypeDtoString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(certificateTypeDtoString, SchemaType.Specialization);
        SpecializationDTO specializationDTO = JsonStringToObjectConverter.convert(certificateTypeDtoString, SpecializationDTO.class);
        return new ResponseEntity<>(specializationService.save(specializationDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        specializationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<SpecializationDTO> findAll(){
        return specializationService.findAll();
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public SpecializationDTO findById(@PathVariable(name="id") Long id){
        return specializationService.findById(id);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<SpecializationDTO> findByName(@PathVariable(name = "name") String name){
        return specializationService.findByName(name);
    }
}
