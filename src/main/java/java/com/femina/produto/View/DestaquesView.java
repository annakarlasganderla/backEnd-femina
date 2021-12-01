package java.com.femina.produto.View;

import java.com.femina.produto.Controller.DestaquesController;
import java.com.femina.produto.Model.Destaques;
import java.com.femina.produto.Model.ProdutoDestaque;
import java.util.Scanner;

public class DestaquesView {

    Scanner leitor = new Scanner(System.in).useDelimiter("\n");
    ProdutoView pv = new ProdutoView();

    public void cadastroDeDestaque(){

        DestaquesController dc = new DestaquesController();
        dc.criaTabelaDestaque();

        int op = 1;

        ProdutoDestaque produtoDestaque = new ProdutoDestaque();

        System.out.println("Digite o Nome da coleção de destaque: ");
        String nome = leitor.next();
        Destaques destaques = new Destaques(nome);

        System.out.println("Digite o id dos produtos dessa coleção ");

        while (op != 0) {
            Produtos produtos = pv.retornaById();
            produtoDestaque.getProdutos().add(produtos);
            System.out.println("Deseja Selecionar mais um produto para essa colecão ?");
            System.out.println("1 - SIM;                                 0 - NÃO;");
            op = leitor.nextInt();
        }

        destaques.setProdutoDestaque(produtoDestaque);

        dc.cadastraDestaque(destaques);

    }

}
