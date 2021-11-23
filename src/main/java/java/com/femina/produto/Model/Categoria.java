package java.com.femina.produto.Model;

public class Categoria {

    private String nome;
    private long id;
    private long idProduto;

    public Categoria(String nome, long id, long idProduto) {
        this.nome = nome;
        this.id = id;
        this.idProduto = idProduto;
    }

    public Categoria() {
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return nome + ";" +
                id + ";" +idProduto;
    }

    public void setNome() {
    }
}
