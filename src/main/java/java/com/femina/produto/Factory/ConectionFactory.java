package java.com.femina.produto.Factory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {

    public Connection getConection() {
        try {
            return DriverManager.getConnection("jdbc:mysql://localhost/femina", "root", "femina123");
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }

}
