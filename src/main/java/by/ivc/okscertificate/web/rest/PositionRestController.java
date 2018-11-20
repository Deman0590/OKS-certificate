package by.ivc.okscertificate.web.rest;

import by.ivc.okscertificate.data.entity.Position;
import by.ivc.okscertificate.service.PositionService;
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

    @Autowired
    public PositionRestController(PositionService positionService) {
        this.positionService = positionService;
    }

    @RequestMapping(method = RequestMethod.POST, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody Position position){
        return new ResponseEntity<>(positionService.save(position), HttpStatus.CREATED);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.DELETE )
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        positionService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @RequestMapping(path = "name/{name}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Position> findByName(@PathVariable(name = "name") String name){
        return positionService.findByName(name);
    }

    @RequestMapping(path = "/{id}", method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public Position findById(@PathVariable(name="id") Long id){
        return positionService.findById(id);
    }

    @RequestMapping(method = RequestMethod.GET, produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<Position> findAll(){
        return positionService.findAll();
    }
}
