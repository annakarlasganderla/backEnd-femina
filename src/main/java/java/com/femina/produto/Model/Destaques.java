package java.com.femina.produto.Model;


public class Destaques {

    private Long idProduto;

    public Destaques(Long idProduto) {
        this.idProduto = idProduto;
    }

    public Destaques() {
    }

    public Long getIdProduto() {
        return idProduto;
    }

    public void setIdProduto(Long idProduto) {
        this.idProduto = idProduto;
    }

    @Override
    public String toString() {
        return idProduto + ";";
    }
}

