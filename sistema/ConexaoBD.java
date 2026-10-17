
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConexaoBD {
    private static final String URL = "jdbc:h2:./banco/hackathon_db";
    private static final String USER = "Rati Ramos";
    private static final String PASSWORD = "28122007";

    public static Connection conectar() {
        try {
            Class.forName("org.h2.Driver");
            return DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (ClassNotFoundException | SQLException e) {
            System.err.println("Erro ao conectar com o Banco de Dados H2: " + e.getMessage());
            return null;
        }
    }
}