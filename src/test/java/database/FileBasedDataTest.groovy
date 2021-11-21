package database

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.FileBasedData
import pl.futurecollars.invoicing.file.FileService

@SpringBootTest
class FileBasedDatabaseTest extends DatabaseTest {

    @Autowired
    FileBasedData fileBasedData

    @Override
    Database getDatabaseInstance() {
        def fileService = new FileService()
        fileService.clearDatabase()
        return fileBasedData
    }
}