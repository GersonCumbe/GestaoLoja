package view;

import javax.swing.*;
import java.awt.*;
import modelo.Produto;
import dao.ProdutoDAO;

public class JanelaProduto extends JFrame {
    
    private JTextField txtId = new JTextField(10);
    private JTextField txtDescricao = new JTextField(20);
    private JTextField txtValor = new JTextField(10);
    private JButton btnSalvar = new JButton("Salvar Produto");
    private ProdutoDAO dao = new ProdutoDAO();

    public JanelaProduto() {
        configurarJanela();
        montarLayout();
        configurarAcoes();
    }

    private void configurarJanela() {
        setTitle("Cadastro de Produtos - Gestão Loja");
        setSize(400, 250);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLocationRelativeTo(null); // Centraliza a janela na tela
    }

    private void montarLayout() {
        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.anchor = GridBagConstraints.WEST;

        // Adicionando campos com GridBag (mais organizado que FlowLayout)
        adicionarComponente(new JLabel("ID:"), 0, 0, gbc);
        adicionarComponente(txtId, 1, 0, gbc);
        
        adicionarComponente(new JLabel("Descrição:"), 0, 1, gbc);
        adicionarComponente(txtDescricao, 1, 1, gbc);
        
        adicionarComponente(new JLabel("Valor:"), 0, 2, gbc);
        adicionarComponente(txtValor, 1, 2, gbc);

        gbc.gridx = 0; gbc.gridy = 3; gbc.gridwidth = 2;
        add(btnSalvar, gbc);
    }

    private void adicionarComponente(Component comp, int x, int y, GridBagConstraints gbc) {
        gbc.gridx = x; gbc.gridy = y;
        add(comp, gbc);
    }

    private void configurarAcoes() {
        btnSalvar.addActionListener(e -> salvarProduto());
    }

    private void salvarProduto() {
        try {
            // Validação simples
            if (txtDescricao.getText().isEmpty()) throw new Exception("Descrição obrigatória!");

            // Criação do objeto (ajuste os campos conforme seu construtor real)
            Produto p = new Produto(
                Long.parseLong(txtId.getText()),
                txtDescricao.getText(),
                Double.parseDouble(txtValor.getText()),
                "Geral", "Marca", 0.0, 0.0, "un"
            );

            dao.cadastrar(p);
            JOptionPane.showMessageDialog(this, "Produto salvo com sucesso!");
            limparCampos();

        } catch (Exception ex) {
            JOptionPane.showMessageDialog(this, "Erro: " + ex.getMessage(), "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    private void limparCampos() {
        txtId.setText("");
        txtDescricao.setText("");
        txtValor.setText("");
    }
    // Ponto de entrada adicionado
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            new JanelaProduto().setVisible(true);
        });
    }
}