/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.login;

/**
 *
 * @author Kaulitz
 */

public class Login {
    
    private final String username;
    
    private String senha;
    
    /**
     * Class constructor 
     * 
     * @param username
     * @param senha 
     * 
     */
    
    public Login(String username, String senha) {
        this.username = username;
        this.senha = senha;
    }
    

    /**
     * Get the value of senha
     *
     * @return the value of senha
     */
    public String getSenha() {
        return senha;
    }

    /**
     * Set the value of senha
     *
     * @param senha new value of senha
     */
    public void setSenha(String senha) {
        this.senha = senha;
    }


    /**
     * Get the value of username
     *
     * @return the value of username
     */
    public String getUsername() {
        return username;
    }

    
}
