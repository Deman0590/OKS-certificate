package by.ivc.okscertificate.web.rest;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToObjectConverter;
import by.ivc.okscertificate.dto.AccountDTO;
import by.ivc.okscertificate.service.AccountService;
import by.ivc.okscertificate.service.ValidationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.annotation.Secured;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "user")
public class AccountRestController {

    private final AccountService userService;
    private final ValidationService validationService;

    @Autowired
    public AccountRestController(AccountService userService, ValidationService validationService) {
        this.userService = userService;
        this.validationService = validationService;
    }

    @PostMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public ResponseEntity create(@RequestBody String userDTOString) throws JsonValidationException, JsonConvertException {
        validationService.validateJson(userDTOString, SchemaType.User);
        AccountDTO userDTO = JsonStringToObjectConverter.convert(userDTOString, AccountDTO.class);
        return new ResponseEntity<>(userService.save(userDTO), HttpStatus.CREATED);
    }

    @DeleteMapping(path = "/{id}")
    public ResponseEntity<Void> delete(@PathVariable(name = "id") Long id){
        userService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    @GetMapping(path = "name/{name}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public AccountDTO findByName(@PathVariable(name = "name") String name){
        return userService.findByName(name);
    }

    @GetMapping(path = "/{id}", produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public AccountDTO findById(@PathVariable(name="id") Long id){
        return userService.findById(id);
    }

//    @Secured(value = {"SUPER_ADMIN", "ADMIN"})
    @GetMapping(produces = MediaType.APPLICATION_PROBLEM_JSON_UTF8_VALUE)
    public List<AccountDTO> findAll(){
//        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        return userService.findAll();
    }
}
