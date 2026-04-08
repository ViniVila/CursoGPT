import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.text.ParseException;

public class Atv1EVO extends JFrame {

    // Campos do formulário
    private JTextField campoNome;
    private JTextField campoEmail;
    private JFormattedTextField campoTelefone;
    private JTextField campoCPF;

    private JButton botaoSalvar;
    private JButton botaoLimpar;

    public Atv1EVO() {

        setTitle("Cadastro de Clientes");
        setSize(420, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();

        gbc.insets = new Insets(5,5,5,5);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        // ===== CAMPO NOME =====
        gbc.gridx = 0;
        gbc.gridy = 0;
        add(new JLabel("Nome:"), gbc);

        gbc.gridx = 1;
        campoNome = new JTextField(20);
        add(campoNome, gbc);

        // ===== CAMPO EMAIL =====
        gbc.gridx = 0;
        gbc.gridy = 1;
        add(new JLabel("E-mail:"), gbc);

        gbc.gridx = 1;
        campoEmail = new JTextField(20);
        add(campoEmail, gbc);

        // ===== CAMPO TELEFONE COM MÁSCARA =====
        gbc.gridx = 0;
        gbc.gridy = 2;
        add(new JLabel("Telefone:"), gbc);

        gbc.gridx = 1;

        try {
            MaskFormatter mascaraTelefone = new MaskFormatter("(##) #####-####");
            mascaraTelefone.setPlaceholderCharacter('_');
            campoTelefone = new JFormattedTextField(mascaraTelefone);
            add(campoTelefone, gbc);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        // ===== CAMPO CPF =====
        gbc.gridx = 0;
        gbc.gridy = 3;
        add(new JLabel("CPF:"), gbc);

        gbc.gridx = 1;
        campoCPF = new JTextField(20);
        add(campoCPF, gbc);

        // ===== BOTÕES =====
        botaoSalvar = new JButton("Salvar");
        botaoLimpar = new JButton("Limpar");

        JPanel painelBotoes = new JPanel();
        painelBotoes.add(botaoSalvar);
        painelBotoes.add(botaoLimpar);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        add(painelBotoes, gbc);

        // ===== EVENTO SALVAR =====
        botaoSalvar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {

                String nome = campoNome.getText();
                String email = campoEmail.getText();
                String telefone = campoTelefone.getText();
                String cpf = campoCPF.getText();

                // Validação simples de CPF
                if(!validarCPF(cpf)){
                    JOptionPane.showMessageDialog(null,
                            "CPF inválido!",
                            "Erro",
                            JOptionPane.ERROR_MESSAGE);
                    return;
                }

                // Salvar no arquivo
                salvarArquivo(nome, email, telefone, cpf);

                JOptionPane.showMessageDialog(null,
                        "Cliente salvo com sucesso!");

                limparCampos();
            }
        });

        // ===== EVENTO LIMPAR =====
        botaoLimpar.addActionListener(e -> limparCampos());
    }

    // ===== MÉTODO PARA LIMPAR CAMPOS =====
    private void limparCampos(){
        campoNome.setText("");
        campoEmail.setText("");
        campoTelefone.setText("");
        campoCPF.setText("");
    }

    // ===== SALVAR DADOS EM ARQUIVO TXT =====
    private void salvarArquivo(String nome, String email, String telefone, String cpf){

        try {

            BufferedWriter writer = new BufferedWriter(
                    new FileWriter("clientes.txt", true));

            writer.write("Nome: " + nome);
            writer.newLine();
            writer.write("Email: " + email);
            writer.newLine();
            writer.write("Telefone: " + telefone);
            writer.newLine();
            writer.write("CPF: " + cpf);
            writer.newLine();
            writer.write("---------------------------");
            writer.newLine();

            writer.close();

        } catch (IOException e) {
            JOptionPane.showMessageDialog(null,
                    "Erro ao salvar arquivo!");
        }

    }

    // ===== VALIDAÇÃO DE CPF =====
    private boolean validarCPF(String cpf){

        cpf = cpf.replaceAll("[^0-9]", "");

        if(cpf.length() != 11) return false;

        // Evita CPFs com todos números iguais
        if(cpf.matches("(\\d)\\1{10}")) return false;

        try {

            int soma = 0;
            for(int i = 0; i < 9; i++){
                soma += (cpf.charAt(i) - '0') * (10 - i);
            }

            int dig1 = 11 - (soma % 11);
            if(dig1 >= 10) dig1 = 0;

            soma = 0;
            for(int i = 0; i < 10; i++){
                soma += (cpf.charAt(i) - '0') * (11 - i);
            }

            int dig2 = 11 - (soma % 11);
            if(dig2 >= 10) dig2 = 0;

            return dig1 == (cpf.charAt(9) - '0') &&
                    dig2 == (cpf.charAt(10) - '0');

        } catch (Exception e){
            return false;
        }
    }

    // ===== MÉTODO MAIN =====
    public static void main(String[] args) {

        SwingUtilities.invokeLater(() -> {
            new Atv1EVO ().setVisible(true);
        });

    }
}