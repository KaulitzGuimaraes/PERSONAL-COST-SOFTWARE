/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.login;

import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.MessageDigest;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;

/**
 *
 * @author Kaulitz
 */
public class CriptografiaLogin {

    private MessageDigest md;
    private String senha;
    private final String key = "Bar%$#%&5Bar+``345";
    private Key aesKey = new SecretKeySpec(key.getBytes(), "AES");
    private  Cipher cipher;
    private byte[] encrypted;

    /**
     *
     * @param Senha
     * @throws NoSuchAlgorithmException
     */
    public CriptografiaLogin(String Senha) throws NoSuchAlgorithmException {
        try {
            this.cipher = Cipher.getInstance("AES");
            this.md = MessageDigest.getInstance("MD5");
            this.senha = senha;
        } catch (NoSuchPaddingException ex) {
            Logger.getLogger(CriptografiaLogin.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }

    private void CriptografaStr(){
        try{
            
            // encrypt the text
            cipher.init(Cipher.ENCRYPT_MODE, aesKey);
            byte[] encrypted = cipher.doFinal(this.senha.getBytes());
    }
        catch(Exception e) 
        {
            e.printStackTrace();
        }
}
    public String descriptografarStr(){
        try{
            
            String decrypted = new String(cipher.doFinal(encrypted));
            return decrypted;
        }
        catch(Exception e) 
        {
            e.printStackTrace();
        
        return null;
        
    }
    }
}