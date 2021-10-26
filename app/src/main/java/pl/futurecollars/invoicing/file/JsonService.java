package pl.futurecollars.invoicing.file;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import java.io.IOException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class JsonService {

    private final ObjectMapper objectMapper = new ObjectMapper();

    public JsonService() {
        objectMapper.findAndRegisterModules();
        objectMapper.enable(SerializationFeature.INDENT_OUTPUT);
        objectMapper.disable(SerializationFeature.WRITE_DATES_AS_TIMESTAMPS);
    }
    public <T> T toObject(String json, Class <T> clazz) throws IOException {
        return objectMapper.readValue(json.getBytes(), clazz);
    }
    public <T> String toJSON (T invoice) throws JsonProcessingException {
        return objectMapper.writeValueAsString(invoice);

    }
}

