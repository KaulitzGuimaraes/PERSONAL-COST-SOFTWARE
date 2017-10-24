/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

/**
 *
 * @author Kaulitz
 */
public abstract class Valor {

    private double numeroValor;

    private LocalDate data;

    public Valor(double numeroValor, LocalDate data) {
        this.numeroValor = numeroValor;
        this.data = data;
    }

    public double getNumeroValor() {
        return numeroValor;
    }

 

    public LocalDate getData() {
        return data;
    }

    public void setData(LocalDate data) {
        this.data = data;
    }


    public void setNumeroValor(double numeroValor) {
        this.numeroValor = numeroValor;
    }

}
