/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.login;

import br.unicamp.si400.crud.Crud;

/**
 *
 * @author Kaulitz
 */
public class Login implements Crud {

    private String senha;
    private final SimpleMd5Example criptogafiaMd5;

    /**
     * Class constructor
     */
    public Login() {
        this.criptogafiaMd5 = new SimpleMd5Example();

    }

    /**
     * Get the value of senha
     *
     * @return the value of senha
     */
    private String getSenha() {
        return this.senha;
    }

    /**
     * Set the value of senha
     *
     * @param senha new value of senha
     */
    private void setSenha(String senha) {
        this.senha = criptogafiaMd5.cripitografarSenha(senha);
    }
    /**
     * Returns the new 
     * temporary password to be changed by 
     * the user.
     * @return String
     */
    public String esqueceuSenha() {
        String novaSenha = gerarNovaSenha();
        return novaSenha;
    }
    /**
     * Genearates a new password (4 numbers) if the user
     * can't remember it and 
     * @return  String
     */
    public String gerarNovaSenha() {
        String novaSenha = "";
        for (int i = 0; i < 4; i++) {
            Integer intBuffer = (int) (Math.random() * 9);
            novaSenha = novaSenha + intBuffer.toString();
            System.out.println(novaSenha);
        }
        return novaSenha;
    }
    /**
     * Creates a password if this one is greater
     * than 4 characters
     * @param data
     * @return boolean
     */
    @Override
    public boolean create(String[] data) {
        if (data[0].length() >= 4 && data[0] != null) {
            setSenha(data[0]);
            return true;
        }
        return false;
    }
    /**
     * Verify the password 
     * @param data
     * @return boolean
     */
    @Override
    public Boolean retrieve(String data) {
        String veifyIfSenhaIsEqual = criptogafiaMd5.cripitografarSenha(data);
        return getSenha().equals(veifyIfSenhaIsEqual);
    }
    /**
     * Change the password
     * @param data
     * @return 
     */
    @Override
    public boolean update(String[] data) {
        if (data[0] != null) {
            setSenha(data[0]);
            return true;
        }
        return false;
    }
    /**
     * Is not possible to implement in this class
     * @param data
     * @return 
     */
    @Override
    public boolean delete(String data) {
        throw new UnsupportedOperationException("You can't delete a password"); //To change body of generated methods, choose Tools | Templates.
    }

    

}
