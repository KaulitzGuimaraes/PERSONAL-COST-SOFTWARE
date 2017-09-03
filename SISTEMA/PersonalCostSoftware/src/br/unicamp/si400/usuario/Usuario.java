/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

import br.unicamp.si400.login.Login;
import br.unicamp.si400.valor.RendaMensal;
import br.unicamp.si400.valor.SobraRendaMensal;
import br.unicamp.si400.valor.Gasto;
import java.util.*;


/**
 *
 * @author Kaulitz
 */
public class Usuario {
    
    private final String nome;
    
    private String email;
    
    private Login login;
    
    private RendaMensal rendaMensal;
    
    private SobraRendaMensal sobraRendaMensal;
    
    private Map gastos = new HashMap();

    /**
     * Get the value of gastos
     *
     * @return the value of gastos
     */
    public Map getGastos() {
        return gastos;
    }

    /**
     * Set the value of gastos
     *
     * @param gasto
     * 
     */
    public void setGastos(Gasto gasto) {
        this.gastos.put(gasto.getDescricao(), gasto);
    }

    
  

    /**
     * Get the value of sobraRendaMensal
     *
     * @return the value of sobraRendaMensal
     */
    public SobraRendaMensal getSobraRendaMensal() {
        return sobraRendaMensal;
    }

    /**
     * Set the value of sobraRendaMensal
     *
     * @param sobraRendaMensal new value of sobraRendaMensal
     */
    public void setSobraRendaMensal(SobraRendaMensal sobraRendaMensal) {
        this.sobraRendaMensal = sobraRendaMensal;
    }


    /**
     * Get the value of rendaMensal
     *
     * @return the value of rendaMensal
     */
    public RendaMensal getRendaMensal() {
        return rendaMensal;
    }
    
    

    /**
     * Set the value of rendaMensal
     *
     * @param rendaMensal new value of rendaMensal
     */
    public void setRendaMensal(RendaMensal rendaMensal) {
        this.rendaMensal = rendaMensal;
    }


    /**
     * Get the object Login
     *
     * @return the login user
     */
    public Login getLogin() {
        return login;
    }

 

    /**
     * Class constructor
     * 
     * @param nome
     * @param email 
     * @param username 
     * @param senha 
     */

    public Usuario(String nome, String email, String username, String senha) {
        this.nome = nome;
        this.email = email;
        this.login = new Login(username,senha);
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
