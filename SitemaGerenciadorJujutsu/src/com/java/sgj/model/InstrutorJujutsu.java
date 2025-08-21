// Dentro de /model/Professor.java
package com.java.sgj.model;

import com.java.sgj.util.Validacoes;

// Professores também herdam a base de AlunoJujutsu
public class InstrutorJujutsu extends AlunoJujutsu {

    private String materiaLecionada; // Ex: Combate, Táticas, Controle de Energia...
    private int anosDeExperiencia;
    private boolean possuiDominio; // Uma informação crucial, não acha? ;)

    // Construtor
    public InstrutorJujutsu() {
        super();
    }

    // --- GETTERS E SETTERS (só para os novos atributos de Professor) ---

    public String getMateriaLecionada() {
        return materiaLecionada;

    }

    public void setMateriaLecionada(String materiaLecionada) {
        this.materiaLecionada = materiaLecionada;
        if (Validacoes.textoEValido(materiaLecionada)) {
            this.materiaLecionada = materiaLecionada;
        } else {
            throw new IllegalArgumentException("A matéria lecionada não pode ser vazia.");
        }
    }

    public int getAnosDeExperiencia() {
        return anosDeExperiencia;
    }

    public void setAnosDeExperiencia(int anosDeExperiencia) {
        // 1º PASSO: Checa na porta.
        if (Validacoes.numeroNaoNegativo(anosDeExperiencia)) {
            // 2º PASSO: Acesso liberado! A informação entra.
            this.anosDeExperiencia = anosDeExperiencia;
        } else {
            // Acesso negado. A informação ruim nem chegou perto do nosso objeto.
            throw new IllegalArgumentException("Anos de experiência não podem ser negativos.");
        }

    }
    public boolean isPossuiDominio() {
        return possuiDominio;
    }

    public void setPossuiDominio(boolean possuiDominio) {
        //Não precisa usar a validação pois o atributo é boolean.
        this.possuiDominio = possuiDominio;
    }
}