package by.ivc.okssertificate.web.rest;

import by.ivc.okssertificate.data.entity.Organization;
import by.ivc.okssertificate.service.OrganizationService;
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

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody Organization organization){
        return new ResponseEntity<>(organizationService.save(organization), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        organizationService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Organization> findByName(@PathVariable(name = "name") String name){
        return organizationService.findByName(name);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Organization findById(@PathVariable(name="id") Long id){
        return organizationService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Organization> findAll(){
        return organizationService.findAll();
    }


}
