import dao.ProdutoDAO;
import modelo.Produto;
import java.util.List;

public class GestaoLoja {
    public static void main(String[] args) {
        
        ProdutoDAO dao = new ProdutoDAO();

    // 1. Criar um novo produto
    // Certifique-se de que o construtor da sua classe Produto aceita estes 8 parâmetros!
    Produto p1 = new Produto(1L, "Arroz", 500.0, "Alimentos", "Marca X", 10.0, 5.0, "kg");

    // 2. Cadastrar no arquivo
    dao.cadastrar(p1);

    // 3. Listar para verificar se apareceu
    System.out.println("\nLista de produtos atualizada:");
    for (Produto p : dao.listarTodos()) {
        System.out.println("ID: " + p.getId() + " | Desc: " + p.getDescricao() + " | Valor: " + p.getValorVenda());
    }
}
}