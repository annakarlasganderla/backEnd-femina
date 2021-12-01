package main.java.com.femina.produto.Controller;

import main.java.com.femina.produto.Dao.FornecedorDao;
import main.java.com.femina.produto.Model.Fornecedor;


import java.util.List;

public class FornecedorController {

    public void cadastrarFornecedor(List<Fornecedor> forn){
        FornecedorDao fd = new FornecedorDao();
        fd.gravarFornecedor(forn);
    }

    public List<Fornecedor> listarFornecedores(){
        FornecedorDao fd = new FornecedorDao();
        List<Fornecedor> lfd = fd.retornaFornecedores();
        return lfd;
    }

    public void editarFornecedor(List<Fornecedor> lfd){
        FornecedorDao fd = new FornecedorDao();
        fd.editFornecedor(lfd);
    }

    public void removerFornecedor(List<Fornecedor> lfd){
        FornecedorDao fd = new FornecedorDao();
        fd.delFornecedor(lfd);
    }
}
