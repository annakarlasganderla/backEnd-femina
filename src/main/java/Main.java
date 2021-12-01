import Model.Cargo;
import Model.Cliente;
import View.CargosView;
import View.ClienteView;
import View.FornecedorView;
import View.ProdutoView;

import java.io.IOException;
import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException, IOException {

        ClienteView cv = new ClienteView();
        cv.cadastrarCliente();
        cv.listarClientes();

//        ProdutoView pv = new ProdutoView();
//
//        pv.listarProdutos();
//        pv.editarProduto();
//        pv.listarProdutos();
////        pv.retornaById();
////        pv.deletarProduto();
    }
}
