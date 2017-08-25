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
public class Usuario {
    
    private final String nome;
    
    private String email;
    /**
     * Class constructor
     * 
     * @param nome
     * @param email 
     */

    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
    }
    
    

    /**
     * Get the value of email
     *
     * @return the value of email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Set the value of email
     *
     * @param email new value of email
     */
    public void setEmail(String email) {
        this.email = email;
    }


    /**
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }
    
    

    
}
