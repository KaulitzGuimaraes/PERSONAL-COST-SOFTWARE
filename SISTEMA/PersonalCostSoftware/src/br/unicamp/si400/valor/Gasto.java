/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

/**
 *
 * @author Kaulitz
 */
public class Gasto extends Valor {

    private final String descricao;

    private final String local;

    private final String formaDePagamento;

    private final String horaDoGasto;

    private final String diaDoGasto;

    private final String mesDoGasto;

    private final String anoDoGasto;

    /**
     *
     * @param descricao
     * @param local
     * @param formaDePagamento
     * @param numeroValor
     * @param tipo
     */
    Gasto(String descricao, String local, String formaDePagamento, String horaDoGasto, String diaDoGasto, String mesDoGasto, String anoDoGasto, double numeroValor, String tipo) {
        super(numeroValor, tipo);
        this.descricao = descricao;
        this.local = local;
        this.formaDePagamento = formaDePagamento;
        this.horaDoGasto = horaDoGasto;
        this.diaDoGasto = diaDoGasto;
        this.mesDoGasto = mesDoGasto;
        this.anoDoGasto = anoDoGasto;
    }

    public String getHoraDoGasto() {
        return horaDoGasto;
    }

    public String getDiaDoGasto() {
        return diaDoGasto;
    }

    public String getMesDoGasto() {
        return mesDoGasto;
    }

    public String getAnoDoGasto() {
        return anoDoGasto;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public String getLocal() {
        return local;
    }

    public String getDescricao() {
        return descricao;
    }

}
