package java.com.femina.produto.Model;

import java.util.ArrayList;

public class ProdutoDestaque {

    private List<Produto> produtos = new ArrayList<>();

    public List<Produto> getProdutos() {
        return produto;
    }

    public void setProdutos(List<Produto> produtos) {
        this.produtos = produto;
    }

    public ProdutoDestaque(List<Produto> produtos) {
        this.produtos = produto;
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
