package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.data.entity.Role;
import by.ivc.okscertificate.dto.OrganizationDTO;
import by.ivc.okscertificate.service.OrganizationService;
import by.ivc.okscertificate.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static by.ivc.okscertificate.data.entity.Role.*;

@RestController
@RequestMapping(value = "organization")
public class OrganizationRestController {

    private final OrganizationService organizationService;
    private final ValidationService validationService;

    @Autowired
    public OrganizationRestController(OrganizationService organizationService, ValidationService validationService) {
        this.organizationService = organizationService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String organizationDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(organizationDTOString, SchemaType.Organization);
        OrganizationDTO organizationDTO = JsonStringToObjectConverter.convert(organizationDTOString, OrganizationDTO.class);
        return new ResponseEntity<>(organizationService.save(organizationDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        organizationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<OrganizationDTO> findByName(@PathVariable(name = "name") String name){
        return organizationService.findByName(name);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public OrganizationDTO findById(@PathVariable(name="id") Long id){
        return organizationService.findById(id);
    }

    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<OrganizationDTO> findAll(){
        return organizationService.findAll();
    }
}
