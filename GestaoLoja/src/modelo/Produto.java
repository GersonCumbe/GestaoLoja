package modelo;

public class Produto{

// Atributos privados (Encapsulamento)
    private Long id;
	private String descricao;
	private Double valorVenda;
	private String categoria;
	private String marca;
	private Double quantidadeEstoque = 0.0;
	private Double conteudo;
	private String unidade;
  
// Construtor da Classe para criar o Objeto
    public Produto(Long id, String descricao,Double valorVenda, String categoria,String marca, Double quantidadeEstoque,Double conteudo,String unidade){
       this.id=id;
       this.descricao= descricao;
       this.valorVenda= valorVenda;
       this.categoria= categoria;
       this.marca=marca;
       this.quantidadeEstoque=quantidadeEstoque;
       this.conteudo= conteudo;
       this.unidade=unidade; 

    } 

    public Produto() { }
    // Getters e Setters (Para acessar e modificar de forma segura)
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    public Double getQuantidadeEstoque() {
        return quantidadeEstoque;
    }

    public void setQuantidadeEstoque(Double quantidadeEstoque) {
        this.quantidadeEstoque = quantidadeEstoque;
    }
    public Double getValorVenda() {
        return valorVenda;
    }

    public void setValorVenda(Double valorVenda) {
        this.valorVenda = valorVenda;
    }
    public String getCategoria() {
        return categoria;
    }
    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }
    public String getMarca() {
        return marca;   
    }
    public void setMarca(String marca) {
        this.marca = marca;
    }
    public Double getConteudo() {
        return conteudo;
    }
    public void setConteudo(Double conteudo) {
        this.conteudo = conteudo;
    }
    public String getUnidade() {
        return unidade;
    }
    public void setUnidade(String unidade) {
        this.unidade = unidade;
    }
    

  
}