public class ProdutoDAO{

    // Definimos o arquivo como "banco de dados"
    private final String caminhoArquivo = "produtos.txt";

    /**
     * Busca todos os registros no arquivo e transforma em objetos Produto.
     * A View chamará este método para preencher as tabelas/listas.
     */

    public List<Produto> listarTodos() {

        // Cria uma lista para armazenar os produtos lidos do arquivo
        List<Produto> listaProdutos = new ArrayList<>();

        // O try-with-resources fecha o leitor automaticamente ao terminar (Pega o arquivo e lê linha por linha)
        try (BufferedReader reader = new BufferedReader(new FileReader(caminhoArquivo))) {
            String linha;
            while ((linha = reader.readLine()) != null) {
                // Ignora linhas vazias para evitar erros de processamento
                if (linha.trim().isEmpty()) continue; 

                // Converte a linha em um objeto Produto usando o método auxiliar
                Produto p = converterLinhaParaProduto(linha);
                if (p != null) { 
                    listaProdutos.add(p);
                }
            }

        } catch (IOException e) {
            System.err.println("Erro ao ler o arquivo de produtos: " + e.getMessage());
        }

        return listaProdutos;
    }

    /**
     * Método auxiliar que converte uma linha de texto em um objeto.
     * Mantém a lógica de conversão organizada e centralizada.
     */
    private Produto converterLinhaParaProduto(String linha) {
    // 1. Validação básica: se a linha for nula ou vazia, nem tenta processar
    if (linha == null || linha.isBlank()) {
        return null;
    }

    try {
        String[] dados = linha.split(";"); 

        // 2. Validação de tamanho: Verifica se temos o número mínimo de colunas esperado.
        // Se esperarmos 5 campos (id, descricao, valor, categoria, marca), 
        // o tamanho do array deve ser 5.
        if (dados.length < 5) {
            System.err.println("Linha incompleta, ignorando: " + linha);
            return null;
        }
        
        Produto p = new Produto();
        
        // 3. Conversão com atribuição direta 
     
        p.setId(Long.parseLong(dados[0].trim()));
        p.setDescricao(dados[1].trim());
        p.setValorVenda(Double.parseDouble(dados[2].trim()));
        p.setCategoria(dados[3].trim());
        p.setMarca(dados[4].trim());
        p.setQuantidadeEstoque(Double.parseDouble(dados[5].trim()));
        p.setConteudo(Double.parseDouble(dados[6].trim()));
        p.setUnidade(dados[7].trim());
        
        return p;
        
    } catch (NumberFormatException e) {
        // 4. Captura erro específico de conversão numérica (mais elegante que Exception genérica)
        System.err.println("Erro na conversão de número na linha: " + linha);
        return null; 
    } catch (Exception e) {
        System.err.println("Erro inesperado ao converter linha: " + e.getMessage());
        return null;
    }
}

/**
     * Salva um novo produto no arquivo.
     * O 'true' no FileWriter indica que queremos anexar ao final do arquivo (append).
     */
    public void salvar(Produto p) {
        // Usamos o formato CSV (separado por ;) para manter a consistência com a leitura
        String linha = p.getId() + ";" + 
                       p.getDescricao() + ";" + 
                       p.getValorVenda() + ";" + 
                       p.getCategoria() + ";" + 
                       p.getMarca() + ";" + 
                       p.getQuantidadeEstoque() + ";" + 
                       p.getConteudo() + ";" + 
                       p.getUnidade();

        // O try-with-resources abre e fecha o arquivo automaticamente
        try (java.io.PrintWriter writer = new java.io.PrintWriter(new java.io.FileWriter(caminhoArquivo, true))) {
            writer.println(linha);
        } catch (java.io.IOException e) {
            System.err.println("Erro ao salvar produto no arquivo: " + e.getMessage());
        }
    }

}