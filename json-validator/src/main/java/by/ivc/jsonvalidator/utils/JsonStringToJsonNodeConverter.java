package by.ivc.jsonvalidator.utils;

import by.ivc.jsonvalidator.exception.JsonConvertException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonStringToJsonNodeConverter {

    private static final ObjectMapper OBJECT_MAPPER = new ObjectMapper();

    public static JsonNode convert(String jsonString) throws JsonConvertException {
        try {
            return OBJECT_MAPPER.readTree(jsonString);
        } catch (IOException e) {
            throw new JsonConvertException(e.getMessage());
        }
    }
}
