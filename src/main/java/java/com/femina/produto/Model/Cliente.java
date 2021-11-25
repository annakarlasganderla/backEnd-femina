package java.com.femina.produto.Model;

public class Cliente {

    private long id_cliente;
    private String nome,senha;
    private int idade;

    private Contatos contatos;
    private Endereco endereco;

    public Cliente() {}

    public Cliente(long id, String nome, String senha, int idade, Endereco endereco) {
        this.id_cliente = id;
        this.nome = nome;
        this.senha = senha;
        this.idade = idade;
        this.endereco = endereco;
    }

    public long getId() {
        return id_cliente;
    }

    public void setId(long id) {
        this.id_cliente = id;
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

    @Override
    public String toString() {
        return  "CLIENTE: " +
                nome + " - " +
                idade + "\n" +
                "   " + contatos.toString() + "\n" +
                "   " + endereco.toString();
    }
}
