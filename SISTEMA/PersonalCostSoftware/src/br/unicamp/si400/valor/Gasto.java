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
    
    private final String dia;
    
    private final String hora;

    public Gasto(String descricao, String local, String formaDePagamento, double numeroValor, String tipo, String hora, String dia, String mes, String ano) {
        super(numeroValor, tipo, mes, ano);
        this.descricao = descricao;
        this.local = local;
        this.formaDePagamento = formaDePagamento;
        this.dia = dia;
        this.hora = hora;
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

    public String getDia() {
        return dia;
    }

    public String getHora() {
        return hora;
    }
    
}
