/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.login;

import java.io.Serializable;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 *
 * @author Lokesh Gupta
 */
public class SimpleMd5Example implements Serializable {

    private String senhaCriptografada;

    /**
     *
     * @param senha
     * @return
     */
    public String cripitografarSenha(String senha) {
        String passwordToHash = senha;
        String generatedPassword ;
        try {
            // Create MessageDigest instance for MD5
            MessageDigest md = MessageDigest.getInstance("MD5");
            //Add password bytes to digest
            md.update(passwordToHash.getBytes());
            //Get the hash's bytes
            byte[] bytes = md.digest();
            //This bytes[] has bytes in decimal format;
            //Convert it to hexadecimal format
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < bytes.length; i++) {
                sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
            }
            //Get complete hashed password in hex format
            generatedPassword = sb.toString();
            // Set the hash password to the class string 'senha'
            this.senhaCriptografada = generatedPassword;
            return this.senhaCriptografada;
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
        return null;

    }
  
}
