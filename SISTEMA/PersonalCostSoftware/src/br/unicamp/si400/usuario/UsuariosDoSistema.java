/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

import br.unicamp.si400.crud.Crud;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaulitz
 */
public class UsuariosDoSistema implements Crud {

    Usuario usuarioAtual;

    /**
     * This method consists in receive a string array that should has the user
     * name and email, then it will insert this values in the object Usuario and
     * insert in the Collection, if the object isn't already there.
     *
     * @param data
     * @return boolean
     */
    @Override
    public boolean create(String[] data) {//Datas into the string must to be name and email
        try {
            this.usuarioAtual = new Usuario(data[0], data[1]);
            return true;
        } catch (NullPointerException e) {
            throw new NullPointerException("Nao foi possivel criar o login");

        }

    }

    /**
     * This method receive the email for the user and verifies if the user is
     * there, so it retrieves the object Usuario .
     *
     * @param data
     * @return Usuario
     */
    @Override
    public Usuario retrieve(String data) {

        try {
            if (data.equals(this.usuarioAtual.toString())) {
                return this.usuarioAtual;
            } else {
                return null;
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Nao foi possivel recuperar dados do usuario");

        }

    }

    /**
     * This method receives the email and the new user name, then it updates the
     * object Usuario in the Set listaDeUsuarios.
     *
     * @param data
     * @return boolean
     */
    @Override
    public boolean update(String[] data) {

        try {
            if (!(data[0].equals(this.usuarioAtual.toString())) && !(this.usuarioAtual.getNome().equals(data[1]))) {
                this.usuarioAtual.setEmail(data[0]);
                this.usuarioAtual.setNome(data[1]);
            }
            return true;

        } catch (NullPointerException e) {
            throw new NullPointerException("Nao foi possivel atualizar dados do usuario");

        }

    }

    /**
     * This method consists in delete an object Usuario if the exists
     *
     * @param data
     * @return boolean
     */
    @Override
    public boolean delete(String data) {

        try {
            if (data.equals(this.usuarioAtual.toString())) {
                this.usuarioAtual = null;
                return true;
            } else {
                return false;
            }
        } catch (NullPointerException e) {
            throw new NullPointerException("Nao foi possivel recuperar dados do usuario");

        }
    }

}
