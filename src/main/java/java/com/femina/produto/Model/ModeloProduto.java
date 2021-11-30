package java.com.femina.produto.Model;

import java.util.ArrayList;
import java.util.List;

public class ModeloProduto {

    private List<ModelosDosProdutos> modelos = new ArrayList<>();

    public ModeloProduto() {
    }

    public List<ModelosDosProdutos> getModelos() {
        return modelos;
    }

    public void setModelos(List<ModelosDosProdutos> modelos) {
        this.modelos = modelos;
    }

    @Override
    public String toString() {
        return "" + modelos;
    }
}
