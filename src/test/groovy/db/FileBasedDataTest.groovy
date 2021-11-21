package db

import pl.futurecollars.invoicing.configuration.FilePathConfiguration
import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.FileBasedData
import pl.futurecollars.invoicing.file.FileService
import pl.futurecollars.invoicing.file.JsonService
import pl.futurecollars.invoicing.model.Invoice


class FileBasedDataTest extends DatabaseTest {

    @Override
    Database getDatabaseInstance() {
        def fileService = new FileService(FilePathConfiguration.FILE_PATH_DATABASE)
        fileService.clearDatabase()
        def invoiceService = new JsonService<Invoice>()
        def idService = new FileService(FilePathConfiguration.FILE_PATH_ID_KEEPER)
        return new FileBasedData(fileService, idService, invoiceService)
    }

}
