package java.com.femina.produto.Model;

import java.com.femina.produto.Model.Cargo;
import java.com.femina.produto.Model.Endereco;

public class Funcionarios {
    private int idFuncionario;
    private String nome;
    private Cargo cargo;
    private Endereco endereco;
    //private Loja loja;

    public Funcionarios(int idFuncionario, String nome, Cargo cargo, Endereco endereco/*, Loja loja*/) {
        this.idFuncionario = idFuncionario;
        this.nome = nome;
        this.cargo = cargo;
        this.endereco = endereco;
        //this.loja = loja;
    }

    public Funcionarios() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public int getId() {
        return idFuncionario;
    }

    public void setId(int id) {
        this.idFuncionario = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Cargo getCargo() {
        return cargo;
    }

    public void setCargo(Cargo cargo) {
        this.cargo = cargo;
    }

    public int getIdFuncionario() {
        return idFuncionario;
    }

    public void setIdFuncionario(int idFuncionario) {
        this.idFuncionario = idFuncionario;
    }

//    public Loja getLoja() {
//        return loja;
//    }
//
//    public void setLoja(Loja loja) {
//        this.loja = loja;
//    }

    @Override
    public String toString() {
        return "Funcionarios{" +
                "idFuncionario=" + idFuncionario +
                ", nome='" + nome + '\'' +
                ", cargo='" + cargo + '\'' +
                /*", idEmpresa=" + loja*/ +
                '}';
    }
}
