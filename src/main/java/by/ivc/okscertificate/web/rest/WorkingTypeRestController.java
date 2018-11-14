package by.ivc.okscertificate.web.rest;

import by.ivc.okscertificate.data.entity.WorkingType;
import by.ivc.okscertificate.service.WorkingTypeService;
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
@RequestMapping(value = "/working/type")
public class WorkingTypeRestController {

    private final WorkingTypeService workingTypeService;

    @Autowired
    public WorkingTypeRestController(WorkingTypeService workingTypeService) {
        this.workingTypeService = workingTypeService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody WorkingType workingType) {
        return new ResponseEntity<>(workingTypeService.save(workingType), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id) {
        workingTypeService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<WorkingType> findAll() {
        return workingTypeService.findAll();
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public WorkingType findById(@PathVariable(name = "id") Long id) {
        return workingTypeService.findById(id);
    }

    @RequestMapping(path = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<WorkingType> findByName(@PathVariable(name = "name") String name) {
        return workingTypeService.findByName(name);
    }
}
