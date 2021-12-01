package Model;

import java.util.ArrayList;
import java.util.List;

public class FuncionariosAux {

    private List<Funcionarios> funcionariosList = new ArrayList<Funcionarios>();

    public FuncionariosAux() {}

    public List<Funcionarios> getFuncionariosList() {
        return funcionariosList;
    }

    public void setProdutosList(List<Funcionarios> produtosList) {
        this.funcionariosList = produtosList;
    }

    @Override
    public String toString() {
        return "FuncionariosAux{" +
                "produtosList=" + funcionariosList +
                '}';
    }
}
