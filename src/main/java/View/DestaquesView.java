package View;

import Controller.DestaquesController;
import Model.Destaques;
import Model.Lojas;
import Model.Produto;
import Model.ProdutoDestaque;

import java.io.IOException;
import java.sql.SQLException;
import java.util.List;
import java.util.Scanner;

public class DestaquesView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n");
    ProdutoView pv = new ProdutoView();

    public void cadastroDeDestaque(Lojas loja) throws SQLException, IOException {

        DestaquesController dc = new DestaquesController();
        dc.criaTabelaDestaque();

        int op = 1;

        ProdutoDestaque produtoDestaque = new ProdutoDestaque();
        Destaques destaques = new Destaques();

        System.out.println("Digite o Nome da coleção de destaque: ");
        destaques.setNome(leitor.next());

        System.out.println("Digite o id dos produtos dessa coleção ");

        while (op != 0) {
            Produto produtos = pv.retornaById(loja);
            produtoDestaque.getProdutos().add(produtos);
            System.out.println("Deseja Selecionar mais um produto para essa colecão ?");
            System.out.println("1 - SIM;                                 0 - NÃO;");
            op = leitor.nextInt();
        }

        destaques.setProdutoDestaque(produtoDestaque);

        dc.cadastraDestaque(destaques);

    }

    public void listarDestaques(Lojas lojas) {

        DestaquesController dc = new DestaquesController();

        List<Destaques> listarDestaques = dc.ListarDestaques(lojas);
        for (int i = 0; i < listarDestaques.size(); i++) {
            System.out.println(listarDestaques.get(i));
        }
    }
}