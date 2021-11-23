package java.com.femina.produto.Model;

import java.com.femina.produto.Model.Endereco;
import java.util.ArrayList;
import java.util.List;

public class Funcionarios {
    private int id;
    private String nome, cargo;
    private Endereco endereco;
    private int idEmpresa;

    public Funcionarios(int id, String nome, String cargo, Endereco endereco, int idEmpresa) {
        this.id = id;
        this.nome = nome;
        this.cargo = cargo;
        this.endereco = endereco;
        this.idEmpresa = idEmpresa;
    }

    public Funcionarios() {
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public long getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }


    @Override
    public String toString() {
        return id + ";" + nome + ";" + cargo + ";" + endereco + ";" +idEmpresa +";";
    }
}
