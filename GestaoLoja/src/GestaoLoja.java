import dao.ProdutoDAO;
import modelo.Produto;
import java.util.List;

public class GestaoLoja {
    public static void main(String[] args) {
        
        ProdutoDAO dao = new ProdutoDAO();

        // 1. Criar um produto para teste
        Produto p1 = new Produto();
        p1.setId(1L);
        p1.setDescricao("Teclado Mecanico");
        p1.setValorVenda(150.0);
        p1.setCategoria("Perifericos");
        p1.setMarca("Logitech");
        p1.setQuantidadeEstoque(10.0);
        p1.setConteudo(1.0);
        p1.setUnidade("Un");

        // 2. Testar o Inserir (Create)
        System.out.println("Salvando produto...");
        dao.salvar(p1);
        System.out.println("Produto salvo!");

        // 3. Testar a Leitura (Read)
        System.out.println("\nLendo produtos do arquivo:");
        List<Produto> lista = dao.listarTodos();
        
        for (Produto p : lista) {
            System.out.println("ID: " + p.getId() + " | Desc: " + p.getDescricao() + " | Valor: " + p.getValorVenda());
        }
    }
}