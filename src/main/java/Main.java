import Dao.FuncionariosDAO;
import View.LojasView;
import View.MenuView;
import View.ProdutoView;

import java.io.IOException;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        MenuView mv = new MenuView();
        mv.menuPrincipal();

    }
}
