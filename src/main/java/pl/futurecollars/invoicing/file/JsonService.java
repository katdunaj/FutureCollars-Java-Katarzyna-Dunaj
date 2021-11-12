package pl.futurecollars.invoicing.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
public class JsonService {

    private final ObjectMapper objectMapper;

    public JsonService() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }

    public <T> T toObject(String json, Class<T> clazz) throws IOException {
        return objectMapper.readValue(json.getBytes(), clazz);
    }

    public <T> String toJson(T invoice) throws JsonProcessingException {
        return objectMapper.writeValueAsString(invoice);

    }

}
