/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.login;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;

/**
 *
 * @author Kaulitz
 */
public class Login implements Crud {

    private String senha;
    private final SimpleMd5Example criptogafiaMd5;
    private String  perguntaSecreta; 
    private String respostaSecreta;

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
     * @throws  ExceptionDefault
     */
    private String getSenha() {
        return this.senha;
    }

    /**
     * Set the value of senha
     *
     * @param senha new value of senha
     * @throws  ExceptionDefault
     */
    private void setSenha(String senha) throws ExceptionDefault {
        this.senha = criptogafiaMd5.cripitografarSenha(senha);
        if (senha == null) {
            throw new ExceptionDefault("Senha Invalida");
        }
    }

    public String getPerguntaSecreta() {
        return perguntaSecreta;
    }

    public String getRespostaSecreta() {
        return respostaSecreta;
    }

    
    /**
     * Returns the new temporary password to be changed by the user.
     *
     * @return String
     * @throws  ExceptionDefault
     */
    public String esqueceuSenha() throws ExceptionDefault {
        String novaSenha = gerarNovaSenha();
        if (novaSenha == null) {
            throw new ExceptionDefault("Senha Invalida");
        }
        return novaSenha;
    }

    /**
     * Genearates a new password (4 numbers) if the user can't remember it and
     *
     * @return String
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
     *  Return a canonical string using the String method internal().
     * 
     * @param el
     * @return String
     */
    private static String canonicString(String el){
        return el.intern();
    }
    /**
     * Verify whether the sended answer is equal the 
     * user answer, returns true whether is yes and false
     * whether is not.
     * 
     * @param data
     * @return 
     */
    public boolean verifyAnswer(String data ){
        
        return this.respostaSecreta.equals(canonicString(data));
    }

    /**
     * Creates a password if this one is greater than 4 characters
     *and set the question and answer for security.
     * 
     * @param data
     * @return boolean
     * @throws  ExceptionDefault
     */
    @Override
    public boolean create(String[] data) throws ExceptionDefault {
        try {
            if (data[0].length() >= 4 && data != null) {
                setSenha(data[0]);
                this.perguntaSecreta = data[1];
                this.respostaSecreta = canonicString(data[2]);
                return true;
            }else{
                throw new ExceptionDefault("Verifique se a senha possui 4 caracteres "
                +"n"+ "e se todos os campos estao preeenchidos");
            }
        } catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new ExceptionDefault("Erro ao criar a senha");

        }
        
    }
    
    /**
     * Verify the password
     *
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
     *
     * @param data
     * @throws  ExceptionDefault
     * @return boolean
     */
    @Override
    public boolean update(String[] data) throws ExceptionDefault {
        try{
        if (data[0] != null) {
            setSenha(data[0]);
            return true;
        }
        }catch (ArrayIndexOutOfBoundsException | NullPointerException e) {
            throw new ExceptionDefault("Erro ao mudar a senha");

        }
        return false;
    }

    /**
     * Is not possible to implement in this class
     *
     * @param data
     * @return
     * @throws  UnsupportedOperationException
     */
    @Override
    public boolean delete(String data) {
        throw new UnsupportedOperationException("You can't delete a password"); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
