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
public interface LoginModel {
    public boolean verificaSenha(String senha);
    public void insereSenha(String senha);
    public void modificaSenha(String senha);
    public String esqueceuSenha();
}
