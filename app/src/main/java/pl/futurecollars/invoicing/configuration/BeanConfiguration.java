package pl.futurecollars.invoicing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.futurecollars.invoicing.file.FileService;

@Configuration
public class BeanConfiguration {

    @Bean
    public FileService jsonFileService() {
        return new FileService(FilePath.JSON_FILE_PATH);
    }

    @Bean
    public FileService idFileService() {
        return new FileService(FilePath.ID_FILE_PATH);
    }
}