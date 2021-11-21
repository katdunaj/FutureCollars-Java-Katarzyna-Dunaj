package db

import pl.futurecollars.invoicing.db.Database
import pl.futurecollars.invoicing.db.InMemoryDatabase

class InMemoryDatabaseTest extends DatabaseTest {


    @Override
    Database getDatabaseInstance() {

        return new InMemoryDatabase()

    }
}
