package org.example;

import java.sql.*;

public class Database {

    private Connection connection = null;

    private static Database instance = null;

    private Database() throws SQLException {

        connection = DriverManager.getConnection("jdbc:sqlite:dabase.db");
    }

    public static Database GetInstance() throws SQLException {
        if(instance == null){
            instance = new Database();
        }
        return instance;
    }

    public void insertPiatto(String nomePiatto, double prezzo, int quantita) {
        // prova connessione

        if(!testConnecrion()){
            throw new RuntimeException("impossibile collegarsi al db");
        }

        // preparazione query

        String query = "INSERT INTO sushi_menu (nome_piatto, prezzo, quantita) VALUES ('" + nomePiatto + "', " + prezzo + ", " + quantita + ")";


        try {
            PreparedStatement statement = connection.prepareStatement(query);

            // esecuzione query
            statement.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

    }

    private boolean testConnecrion() {

        try {
            return connection.isValid(5);
        } catch (SQLException e) {
            return false;
        }
    }
}
