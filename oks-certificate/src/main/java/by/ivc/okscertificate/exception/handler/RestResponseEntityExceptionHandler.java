package by.ivc.okscertificate.exception.handler;

import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    @ExceptionHandler(value = {JsonValidationException.class})
    protected ResponseEntity<Object> validationHandler(Exception e, WebRequest webRequest){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }

    @ExceptionHandler(value = {JsonConvertException.class})
    protected ResponseEntity<Object> convertHandler(Exception e, WebRequest webRequest){
        return handleExceptionInternal(e, e.getMessage(), new HttpHeaders(), HttpStatus.BAD_REQUEST, webRequest);
    }
}
