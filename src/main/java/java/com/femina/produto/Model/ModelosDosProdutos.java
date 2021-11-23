package main.java.com.femina.produto.Model;

public class ModelosDosProdutos {

    private long id;
    private String nomeTipo;
    private long idProduto;

    public ModelosDosProdutos(long id, String nomeTipo) {
        this.id = id;
        this.nomeTipo = nomeTipo;
    }

    public ModelosDosProdutos() {
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNomeTipo() {
        return nomeTipo;
    }

    public void setNomeTipo(String nomeTipo) {
        this.nomeTipo = nomeTipo;
    }

    public long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(long idProduto) {
        this.idProduto = idProduto;
    }

    public String toMostra() {
        return  "Modelo Produto: \n" +
                "Id - " + id + "; " +
                "Nome - " + nomeTipo +
                "\n";
    }

    @Override
    public String toString() {
        return "" + id + ';' +
                nomeTipo + ';' +
                idProduto;
    }
}
