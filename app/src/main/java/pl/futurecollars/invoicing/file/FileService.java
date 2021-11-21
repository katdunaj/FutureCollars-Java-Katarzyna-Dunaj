package pl.futurecollars.invoicing.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import lombok.RequiredArgsConstructor;
import org.apache.commons.io.Charsets;
import org.springframework.stereotype.Service;
import pl.futurecollars.invoicing.configuration.FilePathConfiguration;
@Service
@RequiredArgsConstructor
public class FileService {

    private  final String JSON_FILE_PATH;

    public void writeLines(String line) {
        try {
            Files.writeString(new File(JSON_FILE_PATH).toPath(), line);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readLines() {
        try {
            Files.readAllLines(new File(JSON_FILE_PATH).toPath(), Charsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}