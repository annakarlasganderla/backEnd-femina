package java.com.femina.produto.Model;

public class Produto {

    private long id;
    private String nome;
    private Double preco;
    private int codigo,qtd;
    private Categoria categoria;
    private Marca marca;
    private Fornecedor fornecedor;
    private ModelosDosProdutos modelo;
    private CorProduto cores;
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

    public Marca getMarca() {
        return marca;
    }

    public void setMarca(Marca marca) {
        this.marca = marca;
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

    public CorProduto getCores() {
        return cores;
    }

    public void setCores(CorProduto cores) {
        this.cores = cores;
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
                "|  Cor: " + cores.getCores() + "\n" +
                "|  Marca: " + marca.getNome() + "\n" +
                "|  Tamanho: " + tamanho + "\n" +
                "|  Categoria: " + categoria.getNome() + "\n" +
                "|  Fornecedor: " + fornecedor.getNome() +
                "|-----------------------------------------------|";
    }
}
