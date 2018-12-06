package by.ivc.jsonvalidator;

import by.ivc.jsonvalidator.exception.JsonConvertException;
import by.ivc.jsonvalidator.exception.JsonValidationException;
import by.ivc.jsonvalidator.utils.JsonStringToJsonNodeConverter;
import com.fasterxml.jackson.databind.JsonNode;
import com.github.fge.jackson.JsonLoader;
import com.github.fge.jsonschema.core.exceptions.ProcessingException;
import com.github.fge.jsonschema.core.report.ProcessingMessage;
import com.github.fge.jsonschema.core.report.ProcessingReport;
import com.github.fge.jsonschema.main.JsonSchemaFactory;
import com.github.fge.jsonschema.main.JsonValidator;

import java.io.IOException;

public class JsonSchemaValidator {

    private static final String SCHEMA_PATH = "/schemas";
    private final JsonValidator validator = JsonSchemaFactory.byDefault().getValidator();

    public boolean validate(String jsonString, SchemaType schemaType) throws JsonValidationException, JsonConvertException {
        if (null == jsonString || null == schemaType){
            throw new JsonValidationException("Validation error: input json or schema type is null");
        }
        JsonNode jsonNode = JsonStringToJsonNodeConverter.convert(jsonString);
        if (null != jsonNode) {
            try {
                JsonNode schema = JsonLoader.fromURL(this.getClass().getResource(SCHEMA_PATH + schemaType.getSchema()));
                ProcessingReport report = validator.validate(schema, jsonNode, true);
                if (!report.isSuccess()) {
                    StringBuilder stringBuilder = new StringBuilder();
                    for (ProcessingMessage message : report) {
                        stringBuilder.append(message.getMessage());
                        stringBuilder.append("\n\r");
                    }
                    throw new JsonValidationException("Failed JSON validation: " + stringBuilder.toString());
                }
            } catch (IOException e) {
                throw new JsonValidationException("Validation error: schema not found");
            } catch (ProcessingException e) {
                throw new JsonValidationException("Validation error");
            }
        }
        return false;
    }
}
