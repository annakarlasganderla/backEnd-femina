package Model;

public class Marca {

    private int id;
    private String nome;
    private Contatos contatos;

    public Marca() {
    }

    public Marca(String nome, Contatos contato) {
        this.nome = nome;
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

    public Contatos getContatos() {
        return contatos;
    }

    public void setContatos(Contatos contatos) {this.contatos = contatos;}

    @Override
    public String toString() {
        return "Marca{" +
                "id=" + id +
                ", nome='" + nome + '\'' +
                ", contatos=" + contatos +
                '}';
    }

}
