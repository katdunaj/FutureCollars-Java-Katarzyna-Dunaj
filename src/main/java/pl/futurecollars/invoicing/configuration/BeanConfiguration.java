package pl.futurecollars.invoicing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.futurecollars.invoicing.file.FileService;

@Configuration
public class BeanConfiguration {

    @Bean
    public FileService jsonFileService() {
        return new FileService(FilePathConfiguration.FILE_PATH_DATABASE);
    }

    @Bean
    public FileService idFileService() {
        return new FileService(FilePathConfiguration.FILE_PATH_ID_KEEPER );
    }
}
