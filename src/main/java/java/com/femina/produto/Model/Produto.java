package java.com.femina.produto.Model;

public class Produto {

    private long id;
    private String nome;
    private Double preco;
    private int codigo,qtd;
    private Categoria categoria;
    private Fornecedor fornecedor;
    private ModelosDosProdutos modelo;
    private Cor cor ;
    private Tamanho tamanho;

    public Produto() {}

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

    public Double getPreco() {
        return preco;
    }

    public void setPreco(Double preco) {
        this.preco = preco;
    }

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
        this.codigo = codigo;
    }

    public int getQtd() {
        return qtd;
    }

    public void setQtd(int qtd) {
        this.qtd = qtd;
    }

    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public Fornecedor getFornecedor() {
        return fornecedor;
    }

    public void setFornecedor(Fornecedor fornecedor) {
        this.fornecedor = fornecedor;
    }

    public ModelosDosProdutos getModelo() {
        return modelo;
    }

    public void setModelo(ModelosDosProdutos modelo) {
        this.modelo = modelo;
    }

    public Cor getCor() {
        return cor;
    }

    public void setCor(Cor cor) {
        this.cor = cor;
    }

    public Tamanho getTamanho() {
        return tamanho;
    }

    public void setTamanho(Tamanho tamanho) {
        this.tamanho = tamanho;
    }

    @Override
    public String toString() {
        return "PRODUTO: \n"+
                "|  Código: " + codigo + " - " +
                "|  Nome: " + nome + " \n " +
                "|  Valor: " + preco + " \n " +
                "|  Quantidade: " + qtd + "\n" +
                "|  Cor: " + cor + "\n" +
                "|  Tamanho: " + tamanho + "\n" +
                "|  Categoria: " + categoria.getNome() + "\n" +
                "|  Fornecedor: " + fornecedor.getNome() +
                "|-----------------------------------------------|";
    }
}
