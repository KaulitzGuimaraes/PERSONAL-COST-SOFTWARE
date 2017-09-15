/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kaulitz
 */
public abstract class Valor {

    private long numeroValor;


    private DateTimeFormatter data;

    private String tipo;
    

    public Valor(long numeroValor, String tipo) {
        this.numeroValor = numeroValor;
        this.tipo = tipo;
    }

    /**
     *Get the data
     *
     * @return current data
     */
    public DateTimeFormatter getData() {
        return data;
    }
    /**
     * Get the value of tipo
     *
     * @return the value of tipo
     */
    public String getTipo() {
        return tipo;
    }

    /**
     * Set the value of tipo
     *
     * @param tipo new value of tipo
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    /**
     * Get the value of numeroValor
     *
     * @return the value of numeroValor
     */
    public long getNumeroValor() {
        return numeroValor;
    }

    /**
     * Set the value of numeroValor
     *
     * @param numeroValor new value of numeroValor
     */
    public void setNumeroValor(long numeroValor) {
        this.numeroValor = numeroValor;

    }

}
