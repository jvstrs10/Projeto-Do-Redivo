package com.java.sgj.app;

import com.java.sgj.model.FeiticeiroJujutsu;
import javax.swing.*;
import javax.swing.text.MaskFormatter;
import java.awt.*;
import java.util.HashMap;
import java.util.Map;

/**
 * Este é o Domínio de Cadastro de Feiticeiros!
 * Uma arena especializada para registrar novos alunos e feiticeiros.
 */
public class TelaCadastroFeiticeiro extends JFrame {

    // --- Componentes do nosso Domínio! ---
    private JPanel painelPrincipal, painelFormulario, painelBotoes, painelInfoAdicional;
    private JLabel lblTitulo, lblNome, lblIdade, lblAno, lblTecnica, lblClasse, lblEscola, lblId;
    private JTextField txtNome, txtIdade, txtAno, txtTecnica, txtEscola;
    private JFormattedTextField txtId;
    private JComboBox<String> cmbClasse;
    private JButton btnCriar;
    private JButton btnVoltar; // NOSSO JUTSU DE RETORNO!
    private JTextArea areaResultado;
    private JLabel lblTituloInfoAdicional, lblChaveInfo, lblValorInfo;
    private JTextField txtChaveInfo, txtValorInfo;
    private JButton btnAdicionarInfo;
    private JButton btnLimparInventario;
    private JTextArea areaInfosAdicionadas;
    private Map<String, String> infosAdicionaisTemp;

    public TelaCadastroFeiticeiro() {
        // --- Configurando a Janela Principal (Nossa Barreira) ---
        setTitle("Domínio de Cadastro: Feiticeiro");
        setSize(900, 800);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        setLayout(new BorderLayout());

        infosAdicionaisTemp = new HashMap<>();

        // --- Montando os Painéis e Componentes ---
        painelPrincipal = new JPanel(new BorderLayout(10, 10));
        painelPrincipal.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));

        // --- Painel do Formulário Principal ---
        painelFormulario = new JPanel(new GridLayout(0, 2, 5, 5));
        lblTitulo = new JLabel("--- CADASTRO DE FEITICEIRO JUJUTSU ---");
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 16));
        lblNome = new JLabel("Nome do Feiticeiro:");
        txtNome = new JTextField();
        lblIdade = new JLabel("Idade:");
        txtIdade = new JTextField();
        lblAno = new JLabel("Ano (1, 2 ou 3):");
        txtAno = new JTextField();
        lblTecnica = new JLabel("Técnica Inata:");
        txtTecnica = new JTextField();
        lblEscola = new JLabel("Escola Jujutsu:");
        txtEscola = new JTextField();

        lblId = new JLabel("ID do Feiticeiro (Pacto: JJK-###):");
        try {
            MaskFormatter mascaraId = new MaskFormatter("JJK-###");
            mascaraId.setPlaceholderCharacter('_');
            txtId = new JFormattedTextField(mascaraId);
        } catch (java.text.ParseException e) {
            e.printStackTrace();
            txtId = new JFormattedTextField();
        }

        lblClasse = new JLabel("Classe (Escolha no Pergaminho):");
        String[] classesOficiais = { "Classe 4", "Classe 3", "Semi-2", "Classe 2", "Semi-1", "Classe 1", "Especial 1", "Especial" };
        cmbClasse = new JComboBox<>(classesOficiais);

        painelFormulario.add(lblTitulo);
        painelFormulario.add(new JLabel());
        painelFormulario.add(lblNome);
        painelFormulario.add(txtNome);
        painelFormulario.add(lblIdade);
        painelFormulario.add(txtIdade);
        painelFormulario.add(lblAno);
        painelFormulario.add(txtAno);
        painelFormulario.add(lblTecnica);
        painelFormulario.add(txtTecnica);
        painelFormulario.add(lblClasse);
        painelFormulario.add(cmbClasse);
        painelFormulario.add(lblEscola);
        painelFormulario.add(txtEscola);
        painelFormulario.add(lblId);
        painelFormulario.add(txtId);

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
        painelBotoes = new JPanel(new FlowLayout(FlowLayout.CENTER, 20, 5));
        btnVoltar = new JButton("<< Voltar ao QG");
        btnCriar = new JButton("CADASTRAR FEITICEIRO!");
        btnCriar.setFont(new Font("Arial", Font.BOLD, 20));
        painelBotoes.add(btnVoltar);
        painelBotoes.add(btnCriar);

        // --- Área de Resultado Final ---
        areaResultado = new JTextArea(10, 0);
        areaResultado.setFont(new Font("Monospaced", Font.PLAIN, 14));
        areaResultado.setEditable(false);

        // --- Lógica dos Botões (Cérebros da Operação) ---
        btnVoltar.addActionListener(e -> {
            new TelaInicial(); // Invoca o QG novamente
            this.dispose();    // Desfaz o domínio atual
        });

        btnAdicionarInfo.addActionListener(e -> {
            String chave = txtChaveInfo.getText();
            String valor = txtValorInfo.getText();
            //O && serve para que o "if" não quebre o seu contrato, então ele deve fazer todas as condições para funcionar.
            if (chave != null && !chave.trim().isEmpty() && valor != null && !valor.trim().isEmpty()) {
                infosAdicionaisTemp.put(chave, valor);
                atualizarAreaInventario();
                txtChaveInfo.setText("");
                txtValorInfo.setText("");
                txtChaveInfo.requestFocus();
            } else {
                JOptionPane.showMessageDialog(this, "Ei! Precisa preencher o tipo e o valor do dado!", "CAMPO VAZIO!", JOptionPane.WARNING_MESSAGE);
            }
        });

        btnLimparInventario.addActionListener(e -> {
            infosAdicionaisTemp.clear();
            atualizarAreaInventario();
            JOptionPane.showMessageDialog(this, "Inventário temporário purificado!", "LIMPEZA COMPLETA", JOptionPane.INFORMATION_MESSAGE);
        });

        btnCriar.addActionListener(e -> {
            try {
                FeiticeiroJujutsu novoFeiticeiro = new FeiticeiroJujutsu();
                novoFeiticeiro.setNome(txtNome.getText());
                novoFeiticeiro.setIdade(Integer.parseInt(txtIdade.getText()));
                novoFeiticeiro.setAno(Integer.parseInt(txtAno.getText()));
                novoFeiticeiro.setTecnicaInata(txtTecnica.getText());
                novoFeiticeiro.setEscola(txtEscola.getText());

                String idFeiticeiro = txtId.getText();
                if (idFeiticeiro.contains("_")) {
                    throw new IllegalArgumentException("O ID do Feiticeiro está incompleto!");
                }

                String classeFeiticeiro = (String) cmbClasse.getSelectedItem();
                novoFeiticeiro.setClasse(classeFeiticeiro);

                for (Map.Entry<String, String> entry : infosAdicionaisTemp.entrySet()) {
                    novoFeiticeiro.adicionarInfoAdicional(entry.getKey(), entry.getValue());
                }

                StringBuilder resultado = new StringBuilder();
                resultado.append("FEITICEIRO CADASTRADO COM SUCESSO!\n\n");
                resultado.append("--- FICHA DO NOVO RECRUTA ---\n");
                resultado.append("ID (Pacto Cumprido): ").append(idFeiticeiro).append("\n");
                resultado.append("Nome: ").append(novoFeiticeiro.getNome()).append("\n");
                resultado.append("Idade: ").append(novoFeiticeiro.getIdade()).append("\n");
                resultado.append("Ano: ").append(novoFeiticeiro.getAno()).append("\n");
                resultado.append("Técnica Inata: ").append(novoFeiticeiro.getTecnicaInata()).append("\n");
                resultado.append("Classe (Selecionada): ").append(novoFeiticeiro.getClasse()).append("\n");
                resultado.append("Escola: ").append(novoFeiticeiro.getEscola()).append("\n");
                resultado.append("\n--- INVENTÁRIO DE DADOS ADICIONAIS ---\n");
                Map<String, String> infosFinais = novoFeiticeiro.getTodasInfosAdicionais();
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
                areaResultado.setText("ERRO DE ENERGIA!\n\nIdade e Ano precisam ser NÚMEROS!\nTente de novo, calouro!");
            } catch (IllegalArgumentException ex) {
                areaResultado.setText("BARREIRA ATIVADA!\n\n" + ex.getMessage() + "\n\nCorrija a informação e tente de novo!");
            } catch (Exception ex) {
                areaResultado.setText("ENERGIA AMALDIÇOADA INSTÁVEL!\n\nAlgo explodiu no sistema!\nVerifique se preencheu tudo e tente de novo!");
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
