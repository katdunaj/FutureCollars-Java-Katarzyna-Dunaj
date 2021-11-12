package pl.futurecollars.invoicing.file;

import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import pl.futurecollars.invoicing.configuration.FilePathConfig;

public class FileService {

    public void writeLines(String line) {
        try {
            Files.writeString(new File(FilePathConfig.JSON_FILE_PATH).toPath(), line);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readLines(String line) {
        try {
            Files.readAllLines(new File(FilePathConfig.JSON_FILE_PATH).toPath(), StandardCharsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
