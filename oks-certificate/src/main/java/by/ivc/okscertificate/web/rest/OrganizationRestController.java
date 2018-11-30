package by.ivc.okscertificate.web.rest;

import by.ivc.okscertificate.dto.OrganizationDTO;
import by.ivc.okscertificate.service.OrganizationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "organization")
public class OrganizationRestController {

    private final OrganizationService organizationService;
    @Autowired
    public OrganizationRestController(OrganizationService organizationService) {
        this.organizationService = organizationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody OrganizationDTO organizationDTO){
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
