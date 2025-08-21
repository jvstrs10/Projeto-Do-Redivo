package com.java.sgj.app;

import javax.swing.*;
import java.awt.*;

/**
 * Este é o nosso Quartel-General! A barreira externa do nosso complexo.
 * Simples, direto e com dois portais bem claros para os próximos domínios.
 */
public class TelaInicial extends JFrame {

    private JButton btnCadastrarFeiticeiro;
    private JButton btnCadastrarInstrutor;

    public TelaInicial() {
        // --- Configuração da Janela Principal (O QG) ---
        setTitle("Sistema Gerenciador Jujutsu - Quartel-General");
        setSize(500, 300);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new BorderLayout(20, 20));
        ((JPanel) getContentPane()).setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));

        // --- Título ---
        JLabel lblTitulo = new JLabel("BEM-VINDO AO SISTEMA DE CADASTRO", SwingConstants.CENTER);
        lblTitulo.setFont(new Font("Arial", Font.BOLD, 20));
        add(lblTitulo, BorderLayout.NORTH);

        // --- Painel dos Portais (Botões) ---
        JPanel painelBotoes = new JPanel(new GridLayout(1, 2, 20, 20));
        btnCadastrarFeiticeiro = new JButton("Registrar Feiticeiro");
        btnCadastrarFeiticeiro.setFont(new Font("Arial", Font.PLAIN, 16));
        btnCadastrarInstrutor = new JButton("Registrar Instrutor");
        btnCadastrarInstrutor.setFont(new Font("Arial", Font.PLAIN, 16));

        painelBotoes.add(btnCadastrarFeiticeiro);
        painelBotoes.add(btnCadastrarInstrutor);
        add(painelBotoes, BorderLayout.CENTER);

        // --- Cérebros dos Portais ---
        // O que acontece quando clicamos para registrar um Feiticeiro?
        btnCadastrarFeiticeiro.addActionListener(e -> {
            // Abre o domínio de cadastro de feiticeiros.
            new TelaCadastroFeiticeiro();
            // Fecha o QG para não ficar sobrando.
            this.dispose();
        });

        // E para um Instrutor?
        btnCadastrarInstrutor.addActionListener(e -> {
            // Abre o domínio de cadastro de instrutores.
            new TelaCadastroInstrutor();
            // Fecha o QG.
            this.dispose();
        });

        // --- AÇÃO! ---
        setLocationRelativeTo(null); // Centraliza o QG na tela.
        setVisible(true);
    }
}
