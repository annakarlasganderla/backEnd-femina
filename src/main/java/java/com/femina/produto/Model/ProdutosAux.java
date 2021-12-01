package java.com.femina.produto.Model;

import java.util.ArrayList;
import java.util.List;

public class ProdutosAux {

    private List<Produto> produtosList = new ArrayList<Produto>();

    public ProdutosAux() {}

    public List<Produto> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Produto> produtosList) {
        this.produtosList = produtosList;
    }

    @Override
    public String toString() {
        return "ProdutosAux{" +
                "produtosList=" + produtosList +
                '}';
    }
}
