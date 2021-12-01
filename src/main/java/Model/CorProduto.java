package Model;

import java.util.ArrayList;
import java.util.List;

public class CorProduto {

    private List<Cor> cores = new ArrayList<>();

    public CorProduto() {
    }

    public List<Cor> getCores() {
        return cores;
    }

    public void setCores(List<Cor> cores) {
        this.cores = cores;
    }

    @Override
    public String toString() {
        return "" + cores;
    }
}
