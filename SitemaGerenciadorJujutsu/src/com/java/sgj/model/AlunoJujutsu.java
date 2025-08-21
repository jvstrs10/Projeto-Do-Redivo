package com.java.sgj.model;

// Precisamos invocar as ferramentas para Map e HashMap!
import java.util.HashMap;
import java.util.Map;
import com.java.sgj.util.Validacoes;

public abstract class AlunoJujutsu {

    protected String nome;
    protected int idade;
    protected int ano;
    protected String tecnicaInata;
    protected String classe;
    protected String escola;


    // AQUI ESTÁ A NOSSA NOVA TÉCNICA!
    // Um Mapa que guarda uma String (a etiqueta) e outra String (o valor).
    // A gente já inicializa ele como um HashMap vazio, pronto para usar.
    private Map<String, String> informacoesAdicionais = new HashMap<>();

    // --- MÉTODOS PARA MANIPULAR O INVENTÁRIO ---

    /**
     * Adiciona ou atualiza uma informação personalizada no inventário do feiticeiro.
     * @param chave A etiqueta da informação (ex: "Apelido").
     * @param valor O dado a ser guardado (ex: "O mais forte").
     */
    public void adicionarInfoAdicional(String chave, String valor) {
        // A gente valida tanto a chave quanto o valor, por segurança.
        if (Validacoes.textoEValido(chave) && Validacoes.textoEValido(valor)) {
            // O método .put() faz a mágica: ele cria a etiqueta e guarda o valor.
            // Se a etiqueta já existir, ele só atualiza o valor. Simples assim.
            this.informacoesAdicionais.put(chave, valor);
        } else {
            System.out.println("ERRO: Chave ou valor inválido para informação adicional.");
        }
    }

    /**
     * Busca uma informação no inventário usando a etiqueta.
     * @param chave A etiqueta da informação que você quer ver.
     * @return O valor guardado, ou uma mensagem de "não encontrado".
     */
    public String getInfoAdicional(String chave) {
        // O método .get() busca no inventário pela etiqueta.
        // Se não achar, ele retorna null. A gente trata isso pra ficar mais bonito.
        return this.informacoesAdicionais.getOrDefault(chave, "Informação não encontrada.");
    }

    /**
     * Retorna o inventário completo para podermos fofocar tudo.
     * @return O Mapa completo de informações adicionais.
     */
    public Map<String, String> getTodasInfosAdicionais() {
        return this.informacoesAdicionais;
    }


    // --- O RESTO DA CLASSE (GETTERS E SETTERS) CONTINUA IGUAL ---

    public String getNome() { return nome; }
    public void setNome(String nome) { /* ... com validação ... */
        if (Validacoes.textoEValido(nome)) this.nome = nome;
        else throw new IllegalArgumentException("Nome inválido.");
    }
    public int getIdade() { return idade; }
    public void setIdade(int idade) { /* ... com validação ... */
        if (Validacoes.idadeEValida(idade)) this.idade = idade;
        else throw new IllegalArgumentException("Idade inválida.");
    }
    // ... e assim por diante para os outros atributos ...
    public int getAno() { return ano; }
    public void setAno(int ano) { this.ano = ano; }
    public String getTecnicaInata() { return tecnicaInata; }
    public void setTecnicaInata(String tecnicaInata) { this.tecnicaInata = tecnicaInata; }
    public String getClasse() { return classe; }
    public void setClasse(String classe) { this.classe = classe; }
    public String getEscola() { return escola; }
    public void setEscola(String escola) { this.escola = escola; }
}
