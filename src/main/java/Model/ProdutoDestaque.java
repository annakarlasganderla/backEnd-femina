package Model;

import java.util.ArrayList;
import java.util.List;

public class ProdutoDestaque {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ProdutoDestaque(List<Produto> produtos) {
        this.produtos = produtos;
    }

    public ProdutoDestaque() {
    }

    @Override
    public String toString() {
        return "ProdutoDestaque{" +
                "produtos=" + produtos +
                '}';
    }



}
