package pl.futurecollars.invoicing.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import pl.futurecollars.invoicing.db.Database;
import pl.futurecollars.invoicing.db.FileBasedData;
import pl.futurecollars.invoicing.file.FileService;
import pl.futurecollars.invoicing.file.JsonService;
import pl.futurecollars.invoicing.model.Invoice;

@Configuration
public class BeanConfiguration {

    @Bean
    public Database fileBasedDate(JsonService<Invoice> jsonService) {
        return new FileBasedData(
            new FileService(FilePathConfiguration.FILE_PATH_DATABASE),
            new FileService(FilePathConfiguration.FILE_PATH_ID_KEEPER),
            jsonService);
    }
}