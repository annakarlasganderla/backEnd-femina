import View.MenuView;
import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        MenuView mv = new MenuView();
        mv.menuInicial();

    }
}
