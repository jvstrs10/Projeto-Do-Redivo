package com.java.sgj.util;

/**
 * Esta classe é como o nosso esquadrão de suporte.
 * Contém "feitiços" estáticos (static) e reutilizáveis para validar
 * informações por todo o sistema.
 * A gente centraliza as regras aqui pra não ter que repetir código.
 */
public class Validacoes {

    /**
     * Verifica se um texto (como nome, classe, etc.) é válido.
     * Regra: Não pode ser nulo e não pode ser apenas espaços em branco.
     * @param texto O texto a ser verificado.
     * @return 'true' se for válido, 'false' se for inválido.
     */
    public static boolean textoEValido(String texto) {
        return texto != null && !texto.trim().isEmpty();
    }

    /**
     * Verifica se uma idade é válida para um feiticeiro.
     * Regra: A idade deve ser de 15 anos ou mais.
     * @param idade A idade a ser verificada.
     * @return 'true' se for válida, 'false' se for inválida.
     */
    public static boolean idadeEValida(int idade) {
        return idade >= 15;
    }

    /**
     * Verifica se o ano escolar de um aluno é válido.
     * Regra: Deve ser 1, 2 ou 3.
     * @param ano O ano a ser verificado.
     * @return 'true' se for válido, 'false' se for inválido.
     */
    public static boolean anoEscolarEValido(int ano) {
        return ano >= 1 && ano <= 3;
    }

    /**
     * Verifica se um número (como missões concluídas) não é negativo.
     * Regra: Deve ser 0 ou maior.
     * @param numero O número a ser verificado.
     * @return 'true' se for válido, 'false' se for inválido.
     */
    public static boolean numeroNaoNegativo(int numero) {
        return numero >= 0;
    }


}
