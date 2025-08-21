package com.java.sgj.model;

import com.java.sgj.util.Validacoes;
import java.util.ArrayList;
import java.util.List;

public class FeiticeiroJujutsu extends AlunoJujutsu {

    private int missoesConcluidas;
    private boolean atuandoEmCampo;
    private String especialidade;
    private List<String> habilidadesAdicionais = new ArrayList<>();

    // --- GETTERS E SETTERS (com a nova validação) ---

    public int getMissoesConcluidas() {
        return missoesConcluidas;
    }

    public void setMissoesConcluidas(int missoesConcluidas) {
        // Usando o jutsu de validar número não negativo
        if (Validacoes.numeroNaoNegativo(missoesConcluidas)) {
            this.missoesConcluidas = missoesConcluidas;
        } else {
            throw new IllegalArgumentException("O número de missões não pode ser negativo.");
        }
    }

    // O resto dos getters e setters continua igual...
    public boolean isAtuandoEmCampo() {
        return atuandoEmCampo;
    }

    public void setAtuandoEmCampo(boolean atuandoEmCampo) {
        this.atuandoEmCampo = atuandoEmCampo;
    }

    public String getEspecialidade() {
        return especialidade;
    }

    public void setEspecialidade(String especialidade) {
        this.especialidade = especialidade;
    }

    public List<String> getHabilidadesAdicionais() {
        return habilidadesAdicionais;
    }

    public void setHabilidadesAdicionais(List<String> habilidadesAdicionais) {
        this.habilidadesAdicionais = habilidadesAdicionais;
    }

    public void adicionarHabilidade(String habilidade) {
        if (Validacoes.textoEValido(habilidade)) {
            this.habilidadesAdicionais.add(habilidade);
        }
    }
}
