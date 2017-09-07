/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.login;

import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Kaulitz
 */

public class Login implements LoginModel {
    
    
    private String senha;
    
    /**
     * Class constructor 
     * 
     * @param senha 
     * @throws java.security.NoSuchAlgorithmException 
     * 
     */
    
    public Login(String senha) {
        this.senha = senha; 
    }

    

    /**
     * Get the value of senha
     *
     * @return the value of senha
     */
    public String getSenha() {
        return this.senha;
    }

    /**
     * Set the value of senha
     *
     * @param senha new value of senha
     * @throws java.security.NoSuchAlgorithmException
     */
    public void setSenha(String senha)  {
       this.senha = senha ;
    }

    @Override
    public boolean verificaSenha(String senha) {
        return this.senha.equals(getSenha());
    }
    

    

    
}
