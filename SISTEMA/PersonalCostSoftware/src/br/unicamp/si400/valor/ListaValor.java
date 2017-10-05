/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.excecao.ExceptionDefault;

/**
 *
 * @author Kaulitz
 */
public  abstract class ListaValor {
    
    public abstract double SomaValores(String ano) throws ExceptionDefault;
    public abstract double SomaValores(String mes,String ano) throws ExceptionDefault;
    
    
}
