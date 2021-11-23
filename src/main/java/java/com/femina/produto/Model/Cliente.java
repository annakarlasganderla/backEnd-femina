package java.com.femina.produto.Model;

import main.java.com.femina.produto.Model.Contatos;
import main.java.com.femina.produto.Model.Endereco;

public class Cliente {

    private long id;
    private String nome,senha;
    private int idade;

    private Contatos contatos;
    private Endereco endereco;

    public Cliente() {}

    public Cliente(long id, String nome, String senha, int idade, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.endereco = endereco;
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

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {
        this.contatos = contatos;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public String toMostra() {
        return  "Cliente: " +
                "Id - " + id + "\n" +
                "Nome - " + nome + "\n" +
                "Idade - " + idade +
                "\n" + contatos.toMostra() +
                "\n" + endereco.toMostra() +
                "\n";
    }

    @Override
    public String toString() {
        return  "" + id + ';' +
                nome + ';' +
                idade + ';' +
                senha + ';' +
                contatos.getId() + ';' +
                endereco.getIdEndereco();
    }
}
