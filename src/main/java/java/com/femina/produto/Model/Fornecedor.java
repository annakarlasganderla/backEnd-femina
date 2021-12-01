package java.com.femina.produto.Model;

import java.com.femina.produto.Model.Contatos;
import java.com.femina.produto.Model.Endereco;

public class Fornecedor {

    private int id;
    private String nome;
    private String cnpj;
    private Endereco endereco; // OBJETO -> endereço
    private Contatos contatos;

    public Fornecedor() {
    }

    public Fornecedor(int id, String nome, String cnpj, Endereco endereco, Contatos contatos) {
        this.id = id;
        this.nome = nome;
        this.cnpj = cnpj;
        this.endereco = endereco;
        this.contatos = contatos;
    }

    public int getId() {
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

    public String getCnpj() {
        return cnpj;
    }

    public void setCnpj(String cnpj) {
        this.cnpj = cnpj;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    public String toMostra() {
        return  "Fornecedor: " +
                "Id - " + id + "; " +
                "Nome - " + nome + "; " +
                "Cnpj - " + cnpj + "\n  [" +
                "" + contatos.toMostra() +
                " | " + endereco.toMostra() + "]" +
                "\n";
    }

    @Override
    public String toString() {
        return "" + id + ';' +
                nome + ';' +
                cnpj + ';' +
                contatos.getId() + ';' +
                endereco.getIdEndereco();
    }
}
