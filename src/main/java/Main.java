import Dao.FuncionariosDAO;
import View.LojasView;
import View.ProdutoView;

import java.io.IOException;
import java.sql.SQLException;


public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        LojasView lv = new LojasView();
//        lv.cadastrarLoja();
        lv.verLojas();

    }
}
