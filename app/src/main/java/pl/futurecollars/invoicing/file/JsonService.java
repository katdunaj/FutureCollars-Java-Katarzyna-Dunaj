package pl.futurecollars.invoicing.utils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import java.nio.charset.StandardCharsets;

public class JsonService {

    private final ObjectMapper objectMapper;

    public JsonService() {
        objectMapper = new ObjectMapper();
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    public <T> toObject (String json, Class <T> clazz) throws IOException {
        return objectMapper.readValue(json.getBytes(), clazz)
    }
    public String toJSON (T invoice) throw JsonProcessingException {
        return objectMapper.writeValueAsString(invoice);

    }
}