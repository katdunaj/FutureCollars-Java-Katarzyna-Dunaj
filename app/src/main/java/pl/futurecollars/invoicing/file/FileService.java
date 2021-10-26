package pl.futurecollars.invoicing.utils;


import java.io.File;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import pl.futurecollars.invoicing.configuration.FilePathConfig;

public class FileService {

    public void writeLines(String line) {
        try {
            Files.write(line.getBytes(StandardCharsets.UTF_8), new File(FilePathConfig.JSON_FILE_PATH));
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }

    public void readLines(String line) {
        try {
            Files.readLines(new File(FilePathConfig.JSON_FILE_PATH), Charsets.UTF_8);
        } catch (IOException exception) {
            exception.printStackTrace();
        }
    }
}
