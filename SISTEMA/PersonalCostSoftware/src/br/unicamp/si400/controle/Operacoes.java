/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;

/**
 *
 * @author Kaulitz
 */
public interface Operacoes {
    /**
     * 
     * @param dados 
     */
    public void insert(String [] dados);
    /**
     * 
     * @param chaveDelete
     */
    public void delete(String chaveDelete);
    /**
     * 
     * @param dados 
     */
    public void retrieve(String [] dados);
    /**
     * 
     * @param dados 
     */
    public void update(String [] dados);
}
