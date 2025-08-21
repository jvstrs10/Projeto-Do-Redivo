package com.java.sgj.app;

import com.java.sgj.model.InstrutorJujutsu;
import javax.swing.*;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Este é o Domínio de Cadastro de Instrutores!
 * Uma arena de elite para registrar os mestres do mundo Jujutsu.
 */
public class TelaCadastroInstrutor extends JFrame {

    // --- Componentes do Domínio do Instrutor ---
    private JPanel painelPrincipal, painelFormulario, painelBotoes, painelInfoAdicional;
    private JLabel lblTitulo, lblNome, lblIdade, lblTecnica, lblEscola, lblMateria, lblAnosExp, lblPossuiDominio;
    private JTextField txtNome, txtIdade, txtTecnica, txtEscola, txtMateria, txtAnosExp;
    private JCheckBox chkPossuiDominio; // Nosso interruptor de poder!
    private JButton btnCriar;
    private JButton btnVoltar; // NOSSO JUTSU DE RETORNO!
    private JTextArea areaResultado;

    // --- Componentes para o Laboratório de Customização (reutilizados) ---
    private JLabel lblTituloInfoAdicional, lblChaveInfo, lblValorInfo;
    private JTextField txtChaveInfo, txtValorInfo;
    private JButton btnAdicionarInfo, btnLimparInventario;
    private JTextArea areaInfosAdicionadas;
    private Map<String, String> infosAdicionaisTemp;

    public TelaCadastroInstrutor() {
        // --- Configurando a Janela Principal ---
        setTitle("Domínio de Cadastro: Instrutor");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE); // DISPOSE para só fechar esta janela
        setLayout(new BorderLayout());

        infosAdicionaisTemp = new HashMap<>();

        // --- Montando os Painéis ---
        painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Painel do Formulário Principal ---
        painelFormulario = new JPanel(new GridLayout(0, 2, 5, 5));
        lblTitulo = new JLabel("--- CADASTRO DE INSTRUTOR JUJUTSU ---");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblNome = new JLabel("Nome do Instrutor:");
        txtNome = new JTextField();
        lblIdade = new JLabel("Idade:");
        txtIdade = new JTextField();
        lblTecnica = new JLabel("Técnica Inata Principal:");
        txtTecnica = new JTextField();
        lblEscola = new JLabel("Afiliação (Escola):");
        txtEscola = new JTextField();

        // Campos específicos do Instrutor
        lblMateria = new JLabel("Matéria Lecionada:");
        txtMateria = new JTextField();
        lblAnosExp = new JLabel("Anos de Experiência:");
        txtAnosExp = new JTextField();
        lblPossuiDominio = new JLabel("Possui Expansão de Domínio?");
        chkPossuiDominio = new JCheckBox("Sim, possui");

        painelFormulario.add(lblTitulo);
        painelFormulario.add(new JLabel());
        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);
        painelFormulario.add(lblIdade);
        painelFormulario.add(txtIdade);
        painelFormulario.add(lblTecnica);
        painelFormulario.add(txtTecnica);
        painelFormulario.add(lblEscola);
        painelFormulario.add(txtEscola);
        painelFormulario.add(lblMateria);
        painelFormulario.add(txtMateria);
        painelFormulario.add(lblAnosExp);
        painelFormulario.add(txtAnosExp);
        painelFormulario.add(lblPossuiDominio);
        painelFormulario.add(chkPossuiDominio);

        // --- Painel de Customização ---
        JPanel painelCustomizacao = new JPanel(new BorderLayout(10, 10));
        painelInfoAdicional = new JPanel(new BorderLayout(5, 5));
        JPanel formInfoAdicional = new JPanel(new GridLayout(0, 1, 5, 5));

        lblTituloInfoAdicional = new JLabel("--- INVENTÁRIO DE DADOS CUSTOMIZADOS ---");
        lblTituloInfoAdicional.setFont(new Font("Arial", Font.BOLD, 16));

        lblChaveInfo = new JLabel("Tipo de Dado (Ex: Comida Favorita):");
        txtChaveInfo = new JTextField();
        lblValorInfo = new JLabel("Valor do Dado (Ex: Kikuku Mochi):");
        txtValorInfo = new JTextField();
        btnAdicionarInfo = new JButton("Adicionar Dado ao Inventário");
        btnLimparInventario = new JButton("Limpar Inventário");

        JPanel painelBotoesInventario = new JPanel(new FlowLayout());
        painelBotoesInventario.add(btnAdicionarInfo);
        painelBotoesInventario.add(btnLimparInventario);

        formInfoAdicional.add(lblChaveInfo);
        formInfoAdicional.add(txtChaveInfo);
        formInfoAdicional.add(lblValorInfo);
        formInfoAdicional.add(txtValorInfo);

        painelInfoAdicional.add(formInfoAdicional, BorderLayout.CENTER);
        painelInfoAdicional.add(painelBotoesInventario, BorderLayout.SOUTH);

        areaInfosAdicionadas = new JTextArea();
        areaInfosAdicionadas.setEditable(false);
        areaInfosAdicionadas.setText("Dados customizados aparecerão aqui...");
        areaInfosAdicionadas.setBorder(BorderFactory.createTitledBorder("Inventário Temporário"));

        painelCustomizacao.add(lblTituloInfoAdicional, BorderLayout.NORTH);
        painelCustomizacao.add(painelInfoAdicional, BorderLayout.CENTER);
        painelCustomizacao.add(new JScrollPane(areaInfosAdicionadas), BorderLayout.EAST);


        // --- Botão Principal e Botão Voltar ---
        painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5)); // Adicionado espaçamento
        btnVoltar = new JButton("<< Voltar ao QG");
        btnCriar = new JButton("REGISTRAR INSTRUTOR!");
        btnCriar.setFont(new Font("Arial", Font.BOLD, 20));
        painelBotoes.add(btnVoltar);
        painelBotoes.add(btnCriar);

        // --- Área de Resultado Final ---
        areaResultado = new JTextArea(10, 0);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);

        // --- Lógica dos Botões ---
        btnVoltar.addActionListener(e -> {
            new TelaInicial(); // Invoca o QG novamente
            this.dispose();    // Desfaz o domínio atual
        });

        btnAdicionarInfo.addActionListener(e -> {
            String chave = txtChaveInfo.getText();
            String valor = txtValorInfo.getText();
            if (chave != null && !chave.trim().isEmpty() && valor != null && !valor.trim().isEmpty()) {
                infosAdicionaisTemp.put(chave, valor);
                atualizarAreaInventario();
                txtChaveInfo.setText("");
                txtValorInfo.setText("");
                txtChaveInfo.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "A chave e o valor não podem ser vazios!", "ERRO", JOptionPane.WARNING_MESSAGE);
            }
        });
        // Os && servem para que não haja a necessidade de criar vários ifs e elses

        btnLimparInventario.addActionListener(e -> {
            infosAdicionaisTemp.clear();
            atualizarAreaInventario();
        });

        btnCriar.addActionListener(e -> {
            try {
                InstrutorJujutsu novoInstrutor = new InstrutorJujutsu();
                novoInstrutor.setNome(txtNome.getText());
                novoInstrutor.setIdade(Integer.parseInt(txtIdade.getText()));
                novoInstrutor.setTecnicaInata(txtTecnica.getText());
                novoInstrutor.setEscola(txtEscola.getText());
                novoInstrutor.setMateriaLecionada(txtMateria.getText());
                novoInstrutor.setAnosDeExperiencia(Integer.parseInt(txtAnosExp.getText()));
                novoInstrutor.setPossuiDominio(chkPossuiDominio.isSelected());

                for (Map.Entry<String, String> entry : infosAdicionaisTemp.entrySet()) {
                    novoInstrutor.adicionarInfoAdicional(entry.getKey(), entry.getValue());
                }
    // O StringBuilder é nosso "caldeirão" para montar o texto final.
    // Usamos .append() para adicionar cada "ingrediente" (texto) no final da mistura,
    // de forma muito mais eficiente que usar o sinal de '+'.
                StringBuilder resultado = new StringBuilder();
                resultado.append("INSTRUTOR REGISTRADO COM SUCESSO!\n\n");
                resultado.append("--- FICHA DO MESTRE ---\n");
                resultado.append("Nome: ").append(novoInstrutor.getNome()).append("\n");
                resultado.append("Idade: ").append(novoInstrutor.getIdade()).append("\n");
                resultado.append("Matéria: ").append(novoInstrutor.getMateriaLecionada()).append("\n");
                resultado.append("Experiência: ").append(novoInstrutor.getAnosDeExperiencia()).append(" anos\n");
                resultado.append("Possui Domínio: ").append(novoInstrutor.isPossuiDominio() ? "Sim" : "Não").append("\n");
                resultado.append("\n--- INVENTÁRIO DE DADOS ADICIONAIS ---\n");
                Map<String, String> infosFinais = novoInstrutor.getTodasInfosAdicionais();
                if (infosFinais.isEmpty()) {
                    resultado.append("Nenhum dado customizado adicionado.\n");
                } else {
                    for (Map.Entry<String, String> entry : infosFinais.entrySet()) {
                        resultado.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
                    }
                }

                areaResultado.setText(resultado.toString());
                infosAdicionaisTemp.clear();
                atualizarAreaInventario();

            } catch (NumberFormatException ex) {
                areaResultado.setText("ERRO DE ENERGIA!\n\nIdade e Anos de Experiência precisam ser NÚMEROS!");
            } catch (IllegalArgumentException ex) {
                areaResultado.setText("BARREIRA ATIVADA!\n\n" + ex.getMessage());
            } catch (Exception ex) {
                areaResultado.setText("ENERGIA AMALDIÇOADA INSTÁVEL!\n\nAlgo expludiu no sistema!");
            }
        });

        // --- Juntando Tudo na Janela Principal ---
        painelPrincipal.add(painelFormulario, BorderLayout.NORTH);
        painelPrincipal.add(painelCustomizacao, BorderLayout.CENTER);
        painelPrincipal.add(painelBotoes, BorderLayout.SOUTH);

        add(painelPrincipal, BorderLayout.CENTER);
        add(new JScrollPane(areaResultado), BorderLayout.SOUTH);

        // E... AÇÃO!
        setLocationRelativeTo(null);
        setVisible(true);
    }

    private void atualizarAreaInventario() {
        if (infosAdicionaisTemp.isEmpty()) {
            areaInfosAdicionadas.setText("Dados customizados aparecerão aqui...");
        } else {
            StringBuilder sb = new StringBuilder();
            for (Map.Entry<String, String> entry : infosAdicionaisTemp.entrySet()) {
                sb.append(entry.getKey()).append(": ").append(entry.getValue()).append("\n");
            }
            areaInfosAdicionadas.setText(sb.toString());
        }
    }
}
