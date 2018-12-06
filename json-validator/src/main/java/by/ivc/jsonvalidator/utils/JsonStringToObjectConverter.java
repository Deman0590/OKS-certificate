package by.ivc.jsonvalidator.utils;

import by.ivc.jsonvalidator.exception.JsonConvertException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;

public class JsonStringToObjectConverter {
    public static <T> T convert(String jsonString, Class<T> outClass) throws JsonConvertException {
        if (null != jsonString) {
            ObjectMapper objectMapper = new ObjectMapper();
            try {
                return objectMapper.readValue(jsonString, outClass);
            } catch (IOException e) {
                throw new JsonConvertException(e.getMessage());
            }
        }
        return null;
    }
}
