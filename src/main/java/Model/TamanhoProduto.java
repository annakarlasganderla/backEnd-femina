package Model;

import java.util.ArrayList;
import java.util.List;

public class TamanhoProduto {

    private List<Tamanho> tamanhos = new ArrayList<>();

    public TamanhoProduto() {
    }

    public List<Tamanho> getTamanhos() {
        return tamanhos;
    }

    public void setTamanhos(List<Tamanho> tamanhos) {
        this.tamanhos = tamanhos;
    }

    @Override
    public String toString() {
        return "" + tamanhos;
    }
}
