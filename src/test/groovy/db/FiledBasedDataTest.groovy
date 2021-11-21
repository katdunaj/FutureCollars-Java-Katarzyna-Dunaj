package db

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.FileBasedData
import pl.futurecollars.invoicing.file.FileService
import pl.futurecollars.invoicing.file.JsonService
import pl.futurecollars.invoicing.model.Invoice


class FiledBasedDataTest extends DatabaseTest {

    @Override
    Database getDatabaseInstance() {
        def fileService = new FileService()
        fileService.clearDatabase()
        def invoiceService = new JsonService<Invoice>()
        def idService = new FileService()
        return new FileBasedData(fileService, idService, invoiceService)
    }

}
