/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

import br.unicamp.si400.login.Login;
import br.unicamp.si400.valor.*;
import java.util.*;

/**
 *
 * @author Kaulitz
 */
public class Usuario {

    private String nome;

    private final String email;

    private Login login;

    private RendaMensal rendaMensal;

    private listaGastos listagastos = new listaGastos();

    /**
     * Get the value of gastos
     *
     * @return the value of gastos
     */
    public listaGastos getGastos() {
        return this.listagastos;
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
     */
    public Usuario(String nome, String email) {
        this.nome = nome;
        this.email = email;
        listagastos = new listaGastos();
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
     * Get the value of nome
     *
     * @return the value of nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * Set username
     *
     * @param nome
     */
    public void setNome(String nome) {
        this.nome = nome;
    }

    /**
     * Return the user email
     *
     * @return
     */
    @Override
    public String toString() {
        return this.getEmail();
    }

    /**
     * Verify if the objects has the same email
     *
     * @param anObject
     * @return
     */
    @Override
    public boolean equals(Object anObject) {
        if (anObject == this) {
            return true;
        }

        /* Check if o is an instance of Usuario or not
          "null instanceof [type]" also returns false */
        if (!(anObject instanceof Usuario)) {
            return false;
        }

        // typecast o to Complex so that we can compare data members 
        String compare = anObject.toString();

        // Compare the data members and return accordingly 
        return this.toString().equals(compare);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 17 * hash + Objects.hashCode(this.email);
        return hash;
    }
}
