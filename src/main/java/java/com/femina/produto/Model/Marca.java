package main.java.com.femina.produto.Model;

import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;

import java.util.ArrayList;
import java.util.List;

public class Marca {

    private long id;
    private String nome;
    private Endereco enderecoMarca;
    private Contatos contatos;

    public Marca() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public Endereco getEnderecoMarca() {
        return enderecoMarca;
    }

    public void setEnderecoMarca(Endereco enderecoMarca) {
        this.enderecoMarca = enderecoMarca;
    }

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    public String toMostra() {
        return  "Marca: " +
                "Id - " + id + "; " +
                "Nome - " + nome +  "\n  [" +
                "" + contatos.toMostra() +
                " | " + enderecoMarca.toMostra() + "]" +
                "\n";
    }

    @Override
    public String toString() {
        return "" + id + ';' +
                nome + ';' +
                contatos.getId()+ ';' +
                enderecoMarca.getIdEndereco();
    }
}
