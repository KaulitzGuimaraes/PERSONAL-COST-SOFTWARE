/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.excecao;

import javax.swing.JLabel;

/**
 * 
 * @author Kaulitz
 */
public class ExceptionDefault extends Exception{
    /**
     * Shows the message given when other class throws this error
     * @param mensagem 
     */
    public ExceptionDefault (String mensagem){
        
        System.out.print(mensagem);
        
    }
}
