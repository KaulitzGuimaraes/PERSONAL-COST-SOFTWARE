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
    
  

    private double numeroValor;


    private String tipo;
    

    private final String mes;

    private final String ano;

    public Valor(double numeroValor, String tipo, String mes, String ano) {
        this.numeroValor = numeroValor;
        this.tipo = tipo;
        this.mes = mes;
        this.ano = ano;
    }

    public double getNumeroValor() {
        return numeroValor;
    }

    public String getTipo() {
        return tipo;
    }

    public String getMes() {
        return mes;
    }

    public String getAno() {
        return ano;
    }


    @Override
    public String toString(){
        return this.getTipo();
    
    }

    public void setNumeroValor(double numeroValor) {
        this.numeroValor = numeroValor;
    }
    
    

}
