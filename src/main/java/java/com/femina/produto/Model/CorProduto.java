package java.com.femina.produto.Model;

import java.util.List;

public class CorProduto {

    private Produto produto;
    private List<Cor> cores;

    public CorProduto() {
    }

    public Produto getProduto() {
        return produto;
    }

    public void setProduto(Produto produto) {
        this.produto = produto;
    }

    public List<Cor> getCores() {
        return cores;
    }

    public void setCores(List<Cor> cores) {
        this.cores = cores;
    }

    @Override
    public String toString() {
        return "CorProduto{" +
                ", cores=" + cores +
                '}';
    }
}
