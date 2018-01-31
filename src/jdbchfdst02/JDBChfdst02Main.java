package jdbchfdst02;
/*
De packages java.sql en javax.sql bevatten de JDBC classes en interfaces.
Ook andere packages bevatten een interface Connection, maar dat is geen JDBC Connection.
De package com.mysql.jdbc bevat ook een interface Connection.
Deze stelt een connectie voor naar MySQL, niet naar andere databasemerken.
We gebruiken deze interface niet: zo werkt ons programma met alle merken databases.
*/
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
public class JDBChfdst02Main {
    /*
    Maakt de JDBC URL.
    Geeft in de JDBC URL een parameter useSSL mee die je op false plaatst.
    Dit geeft aan dat het dataverkeer tussen je applicatie en de database niet geëncrypteerd wordt.
    De configuratie van geëncrypteerd dataverkeer is complex en valt buiten het bereik van deze cursus.
    Moderne versies van MySQL geven een warning als je deze parameter niet meegeeft.
    */
    private static final String URL = "jdbc:mysql://localhost/tuincentrum?useSSL=false";
    private static final String USER = "cursist";
    private static final String PASSWORD = "cursist";
    public static void main(String[] args) {
        /*
        Connection erft van AutoCloseable.
        Als je de Connection variabele declareert en initialiseert binnen de ronde haakjes van de try,
        voegt de compiler zelf een finally blok aan dit try blok toe waarin hij de Connection sluit.
        */
        try (Connection connection = 
                /*
                Maakt een verbinding met de db tuincentrum op de eigen computer.
                Verbindt met de gebruikersnaam root en het bijbehorende passwoord vdab.
                */
                DriverManager.getConnection(URL, USER, PASSWORD)) {
            System.out.println("Connectie geopend");
        }
        /*
        De verbinding is mislukt.
        (Redenen: tikfout in de JDBC URL, MySQL is niet gestart, de db tuincentrum bestaat niet, verkeerd paswoord, ...)
        JDBC werpt dan een SQLException.
        */
        catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
    
}
