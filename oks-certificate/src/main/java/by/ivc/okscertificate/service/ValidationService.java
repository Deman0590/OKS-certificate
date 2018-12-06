package by.ivc.okscertificate.service;

import by.ivc.jsonvalidator.SchemaType;
import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;

public interface ValidationService {

    void validateJson(String jsonString, SchemaType schemaType) throws JsonValidationException, JsonConvertException;
}
