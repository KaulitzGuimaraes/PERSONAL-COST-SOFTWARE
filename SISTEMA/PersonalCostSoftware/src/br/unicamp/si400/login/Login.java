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

public class Login implements LoginModel {
    
    
    private String senha;
    private final SimpleMd5Example criptogafiaMd5;
    /**
     * Class constructor 
     * 
     * 
     */
    
    public Login() {
        this.criptogafiaMd5 = new SimpleMd5Example();
         
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
     */
    public void setSenha(String senha)  {
       this.senha = criptogafiaMd5.cripitografarSenha(senha); 
    }

    @Override
    public boolean verificaSenha(String senha) {
        String strCriptografada = criptogafiaMd5.cripitografarSenha(senha);
        return strCriptografada.equals(this.senha);
    }

    @Override
    public void insereSenha(String senha) {
        
       this.senha = criptogafiaMd5.cripitografarSenha(senha);
    }

    @Override
    public void modificaSenha(String senha) {
       setSenha(senha);
    }
    @Override
    public String esqueceuSenha() {
        String novaSenha = gerarNovaSenha();
        return novaSenha;
    }
    public String gerarNovaSenha(){
            String novaSenha = "";
        for (int i=0; i<4; i++){
            Integer intBuffer = (int) (Math.random()*9);
            novaSenha = novaSenha + intBuffer.toString();
            System.out.println(novaSenha);
        }
        return novaSenha;
    }

    

    
}
