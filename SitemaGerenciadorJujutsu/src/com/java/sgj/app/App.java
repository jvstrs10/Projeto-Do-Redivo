package com.java.sgj.app;

import javax.swing.SwingUtilities;

public class App {
    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> {
            // A ordem agora é invocar o Quartel-General!
            // O resto do fluxo acontece a partir de lá.
            new TelaInicial();
        });
        System.out.println("Comando de invocação do QG enviado...");
    }
}
