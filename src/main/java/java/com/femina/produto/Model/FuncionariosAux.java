package java.com.femina.produto.Model;

import java.util.ArrayList;
import java.util.List;

public class FuncionariosAux {

    private List<Funcionarios> produtosList = new ArrayList<Funcionarios>();

    public FuncionariosAux() {}

    public List<Funcionarios> getProdutosList() {
        return produtosList;
    }

    public void setProdutosList(List<Funcionarios> produtosList) {
        this.produtosList = produtosList;
    }

    @Override
    public String toString() {
        return "FuncionariosAux{" +
                "produtosList=" + produtosList +
                '}';
    }
}
