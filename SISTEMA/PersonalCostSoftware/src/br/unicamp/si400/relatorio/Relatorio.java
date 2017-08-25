/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.relatorio;

import java.io.File;
import java.time.LocalDate;

/**
 *
 * @author Kaulitz
 */
public class Relatorio {
    
    private String tipo;
       
    private LocalDate data;
    
    private String descricao;
    
    private File string;

    public Relatorio(String tipo, String descricao) {
        this.tipo = tipo;
        this.descricao = descricao;
    }
    
    

    /**
     * Get the value of string
     *
     * @return the value of string
     */
    public File getString() {
        return string;
    }

    /**
     * Set the value of string
     *
     * @param string new value of string
     */
    public void setString(File string) {
        this.string = string;
    }


    /**
     * Get the value of descricao
     *
     * @return the value of descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Set the value of descricao
     *
     * @param descricao new value of descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    

    /**
     * Get the value of data
     *
     * @return the value of data
     */
    public LocalDate getData() {
        return data;
    }

    /**
     * Set the value of data
     *
     * @param data new value of data
     */
    public void setData(LocalDate data) {
        this.data = data;
    }


    /**
     * Get the value of tipo
     *
     * @return the value of tipo
     */
    public String getTipo() {
        return tipo;
    }
 
    
}
