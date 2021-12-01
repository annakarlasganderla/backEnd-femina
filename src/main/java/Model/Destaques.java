package Model;


public class Destaques {

    private int idDestaque;
    private String nome;
    private ProdutoDestaque produtoDestaque;

    public Destaques() {
    }

    public Destaques(String nome) {
    }

    public int getIdDestaque() {
        return idDestaque;
    }

    public void setIdDestaque(int idDestaque) {
        this.idDestaque = idDestaque;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public ProdutoDestaque getProdutoDestaque() {
        return produtoDestaque;
    }

    public void setProdutoDestaque(ProdutoDestaque produtoDestaque) {
        this.produtoDestaque = produtoDestaque;
    }

    @Override
    public String toString() {
        return "Destaques{" +
                "idDestaque=" + idDestaque +
                ", nome='" + nome + '\'' +
                ", produtoDestaque=" + produtoDestaque +
                '}';
    }



}