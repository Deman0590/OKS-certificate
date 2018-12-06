package by.ivc.okscertificate.service.implementation;

import by.ivc.jsonvalidator.JsonSchemaValidator;
import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.okscertificate.service.ValidationService;
import org.springframework.stereotype.Service;

@Service
public class ValidationServiceImpl implements ValidationService {

    private final JsonSchemaValidator jsonSchemaValidator = new JsonSchemaValidator();

    @Override
    public void validateJson(String jsonString, SchemaType schemaType) throws JsonValidationException, JsonConvertException {
        jsonSchemaValidator.validate(jsonString, schemaType);
    }
}
