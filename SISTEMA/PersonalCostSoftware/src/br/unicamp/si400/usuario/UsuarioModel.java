/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

/**
 *
 * @author Kaulitz
 */
public interface UsuarioModel {
    /**
     * 
     */
    public void novoUsuario(String dados[]);
    /**
     * 
     * @return 
     */
    public boolean checarListaUsuario(String dado);
    /**
     * 
     * @param dados
     */
    public void atualizarDadosUsuario(String dados[]);
    
    /**
     * 
     * @param dados
     */
    public void deletarUsuario(String dados[]);
    /**
     * 
     * @param dados
     * @return 
     */
    public String[] recuperarDadosUsuario(String dado);
}
