/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.crud;

/**
 *
 * @author Kaulitz
 */
public interface Crud {
    /**
     * 
     * @param data
     * @return 
     */
    boolean create(String[] data);
    /**
     * 
     * @param data
     * @return 
     */
    Object retrieve(String data);
    /**
     * 
     * @param data
     * @return 
     */
    boolean update(String[] data);
    /**
     * 
     * @param data
     * @return boolean
     */
    boolean delete(String data);
    
}
