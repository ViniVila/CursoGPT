import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
 * Classe principal do programa.
 * Ela cria a janela do formulário de cadastro de clientes.
 */
public class Atv1 extends JFrame {

    // Campos de texto do formulário
    private JTextField campoNome;
    private JTextField campoEmail;
    private JTextField campoTelefone;
    private JTextField campoCPF;

    // Botões do formulário
    private JButton botaoSalvar;
    private JButton botaoLimpar;

    /*
     * Construtor da classe.
     * Aqui configuramos a janela e adicionamos os componentes.
     */
    public Atv1() {

        // Define o título da janela
        setTitle("Cadastro de Clientes");

        // Define o tamanho da janela
        setSize(400, 300);

        // Define o comportamento ao fechar a janela
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        // Centraliza a janela na tela
        setLocationRelativeTo(null);

        // Define o layout da janela como GridBagLayout
        setLayout(new GridBagLayout());

        // Objeto usado para configurar posição e espaçamento dos componentes
        GridBagConstraints gbc = new GridBagConstraints();

        // Define espaçamento interno entre os componentes
        gbc.insets = new Insets(5, 5, 5, 5);

        // Faz os componentes ocuparem espaço horizontal
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== CRIAÇÃO DOS CAMPOS =====

        // Campo Nome
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        campoNome = new JTextField(20);
        add(campoNome, gbc);

        // Campo Email
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("E-mail:"), gbc);

        gbc.gridx = 1;
        campoEmail = new JTextField(20);
        add(campoEmail, gbc);

        // Campo Telefone
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;
        campoTelefone = new JTextField(20);
        add(campoTelefone, gbc);

        // Campo CPF
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("CPF:"), gbc);

        gbc.gridx = 1;
        campoCPF = new JTextField(20);
        add(campoCPF, gbc);

        // ===== CRIAÇÃO DOS BOTÕES =====

        botaoSalvar = new JButton("Salvar");
        botaoLimpar = new JButton("Limpar");

        // Painel para agrupar os botões
        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoLimpar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2; // Faz o painel ocupar duas colunas
        add(painelBotoes, gbc);

        // ===== EVENTO DO BOTÃO SALVAR =====
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Pega os valores digitados nos campos
                String nome = campoNome.getText();
                String email = campoEmail.getText();
                String telefone = campoTelefone.getText();
                String cpf = campoCPF.getText();

                // Exibe os dados em uma caixa de diálogo
                JOptionPane.showMessageDialog(null,
                        "Dados cadastrados:\n\n"
                                + "Nome: " + nome + "\n"
                                + "E-mail: " + email + "\n"
                                + "Telefone: " + telefone + "\n"
                                + "CPF: " + cpf);
            }
        });

        // ===== EVENTO DO BOTÃO LIMPAR =====
        botaoLimpar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                // Limpa todos os campos do formulário
                campoNome.setText("");
                campoEmail.setText("");
                campoTelefone.setText("");
                campoCPF.setText("");
            }
        });
    }

    /*
     * Método principal (main).
     * É o ponto de entrada do programa.
     */
    public static void main(String[] args) {

        // Executa a interface gráfica na thread correta do Swing
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                // Cria o formulário
                Atv1 tela = new Atv1();

                // Torna a janela visível
                tela.setVisible(true);
            }
        });
    }
}