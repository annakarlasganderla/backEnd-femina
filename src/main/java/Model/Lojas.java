package Model;

public class Lojas {
    private int id;
    private String nome;
    private Endereco endereco;
    private Contatos contatos;
    private FuncionariosAux funcionarios;

    public Lojas() {
    }

    public Lojas(int id, String nome) {
        this.id = id;
        this.nome = nome;
    }

    public Lojas(int id, String nome, Endereco endereco) {
        this.id = id;
        this.nome = nome;
        this.endereco = endereco;
    }

    public Lojas(Lojas loja){
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

    public FuncionariosAux getFuncionarios() {
        return funcionarios;
    }

    public void setFuncionarios(FuncionariosAux funcionarios) {
        this.funcionarios = funcionarios;
    }


    @Override
    public String toString() {
        return id + ";" + nome + ";" + endereco + ";" + contatos + ";" + funcionarios /*+ ";" + produtos*/ ;
    }
}
