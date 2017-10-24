/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaulitz
 */
public class UsuariosDoSistema implements Crud,Serializable {

    Set<Usuario> usuarioAtual;

    public UsuariosDoSistema() {
        
        this.usuarioAtual =  new HashSet();
    }

    public Set<Usuario> getUsuarioAtual() {
        return usuarioAtual;
    }

    
    
    /**
     * This method consists in receive a string array that should has the user
     * name and email, then it will insert this values in the object Usuario and
     * insert in the Collection, if the object isn't already there.
     *
     * @param data
     * @return boolean
     */
    @Override
    public boolean create(String[] data) throws ExceptionDefault {//Datas into the string must to be name and email
        try {
            Usuario i = new Usuario(data[0], data[1]);
            if (!this.usuarioAtual.add(i)){
                throw new ExceptionDefault("Nao foi possivel criar o login");
                
            }
            
           
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Nao foi possivel criar o login");

        }
        return true;
    }

    /**
     * This method receive the email for the user and verifies if the user is
     * there, so it retrieves the object Usuario .
     *
     * @param data
     * @return Usuario
     */
    @Override
    public Usuario retrieve(String data) throws ExceptionDefault {

        try {
            for (Usuario el : this.usuarioAtual) {
                if (data.equals(el.getEmail())) {
                    return el;
                }
            }
            return null;
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Nao foi possivel recuperar dados do usuario");

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
    public boolean update(String[] data) throws ExceptionDefault {

        try {
               for (Usuario el : this.usuarioAtual) {
                if (data[0].equals(this.usuarioAtual.toString())) {
                    el.setEmail(data[0]);
                    el.setNome(data[1]);
                    return true;
                }
            }

        } catch (NullPointerException e) {
            throw new ExceptionDefault("Nao foi possivel atualizar dados do usuario");

        }
        return false;

    }

    /**
     * This method consists in delete an object Usuario if the exists
     *
     * @param data
     * @return boolean
     */
    @Override
    public boolean delete(String data) throws ExceptionDefault {

        try {
           for (Usuario el : this.usuarioAtual) {
                if (data.equals(this.usuarioAtual.toString())) {
                    this.usuarioAtual.remove(el);
                    return true;
                }
            }
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Nao foi possivel recuperar dados do usuario");

        }
        return false;
    }
    

}
