package java.com.femina.produto.Model;

import java.util.ArrayList;
import java.util.List;

public class FornecedorProduto {

    private List<Fornecedor> fornecedores = new ArrayList<>();

    public FornecedorProduto() {
    }

    public List<Fornecedor> getFornecedores() {
        return fornecedores;
    }

    public void setFornecedores(List<Fornecedor> fornecedores) {
        this.fornecedores = fornecedores;
    }

    @Override
    public String toString() {
        return "" + fornecedores;
    }
}
