/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import java.time.LocalDate;
import java.time.LocalTime;

/**
 *
 * @author Kaulitz
 */
public class Gasto extends Valor {

    private final String descricao;

    private final String local;
    
    private String tipo;

    private final String formaDePagamento;
    
    private final LocalTime hora; 

    public Gasto(String descricao, String local, String formaDePagamento, double numeroValor, LocalDate data, LocalTime hora) {
        super(numeroValor, data);
        this.descricao = descricao;
        this.local = local;
        this.formaDePagamento = formaDePagamento;
        this.hora = hora;
        this.tipo = tipo;
    }

    public String getDescricao() {
        return descricao;
    }

    public String getLocal() {
        return local;
    }

    public String getTipo() {
        return tipo;
    }

    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    public LocalTime getHora() {
        return hora;
    }
    
   
    
    @Override
    public String toString() {
        return this.getTipo();

    }
    
    
}
