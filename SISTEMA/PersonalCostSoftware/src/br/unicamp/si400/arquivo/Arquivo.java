/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.arquivo;
import java.time.LocalDate;
/**
 *
 * @author Kaulitz
 */
public class Arquivo {
    private final String name;
    
    private final String tipo;
    
    private  String data;
    
   //classe abstrata que será usada para manipulacao de aquivos
    /**
     * 
     * @param name
     * @param tipo 
     */
    public Arquivo(String name, String tipo) {
        this.name = name;
        this.tipo = tipo;
    }
    
   
    
}
