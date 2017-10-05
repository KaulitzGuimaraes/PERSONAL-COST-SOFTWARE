/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.crud;

import br.unicamp.si400.excecao.ExceptionDefault;

/**
 *
 * @author Kaulitz
 */
public interface Crud {
    /**
     * 
     * @param data
     * @return 
     * @throws br.unicamp.si400.excecao.ExceptionDefault 
     */
   public abstract boolean create(String[] data) throws ExceptionDefault;
    /**
     * 
     * @param data
     * @return 
     * @throws br.unicamp.si400.excecao.ExceptionDefault 
     */
    public abstract Object retrieve(String data) throws ExceptionDefault;
    /**
     * 
     * @param data
     * @return 
     * @throws br.unicamp.si400.excecao.ExceptionDefault 
     */
    public abstract boolean update(String[] data) throws ExceptionDefault;
    /**
     * 
     * @param data
     * @return boolean
     * @throws br.unicamp.si400.excecao.ExceptionDefault
     */
    public abstract boolean delete(String data) throws ExceptionDefault;
    
}
