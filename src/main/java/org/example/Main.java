package org.example;

import java.sql.SQLException;

import static java.lang.IO.println;
import static java.lang.IO.readln;

public class Main {
    static void main() {

        Database database = null;

        try {

            database = Database.GetInstance();

        } catch (SQLException e) {
            println("impossibile connettersi al database");
            System.exit(-1);
        }

        println("connesso al db");

        database.insertPiatto(readln("inserisci nome piatto: ").trim(),
                Double.parseDouble(readln("inserisci prezzo: ").trim()),
                Integer.parseInt(readln("inserisci quantita: ").trim()));

    }
}
