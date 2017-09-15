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

/**
 *
 * @author Kaulitz
 */
public class UsuariosDoSistema implements Crud {

    private Set<Usuario> listaDeUsuarios;
    private Iterator<Usuario> iterator;
    /**
     * Initialize the Set listaDeUsuarios
     */
    public UsuariosDoSistema() {
        
        this.listaDeUsuarios = new HashSet();
        
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
    public boolean create(String[] data) {//Datas into the string must to be name and email
        Usuario usuarioBuffer = new Usuario(data[0], data[1]);
        return this.listaDeUsuarios.add(usuarioBuffer);
       
    }
    /**
     * This method consists in receive an already made object,
     * then it will insert this values in the object Usuario and
     * insert in the Collection, if the object isn't already there.
     *
     * @param data
     * @return boolean
     */
    public boolean create(Usuario  data) {//Datas into the string must to be name and email
        return this.listaDeUsuarios.add(data);
       
    }
    /**
     * This method receive the email for the user and verifies if the user is there,
     * so it retrieves the object Usuario .
     * @param data
     * @return Usuario
     */
    @Override
    public Usuario retrieve(String data) {
        
         this.iterator = this.listaDeUsuarios.iterator();
         Usuario usuarioBuffer;
        
            while (this.iterator.hasNext()) {
                usuarioBuffer= this.iterator.next();
                if(usuarioBuffer.toString().equals(data)){
                    return usuarioBuffer;
                }
                
                
            }
        return null;
        
    }
    
    /**
     * This method receives the email and the new user name,
     * then it updates the object Usuario in the Set 
     * listaDeUsuarios.
     * @param data
     * @return boolean
     */
    @Override
    public boolean update(String[] data) {
       
        this.iterator = this.listaDeUsuarios.iterator();
         Usuario usuarioBuffer = retrieve(data[1]);
         
          if(delete(data[1])){
              usuarioBuffer.setNome(data[0]);
              create(usuarioBuffer);
              return true;
          }
              return false;
          
        
          
                
            
    
    }
    /**
     * This method consists in delete an object Usuario if the exists
     * @param data
     * @return boolean
     */
    @Override
    public boolean delete(String data) {
      this.iterator = this.listaDeUsuarios.iterator();
        while (this.iterator.hasNext()) {
            
            
                Usuario usuarioBuffer = iterator.next();
       
                
                if (usuarioBuffer.toString().equals(data)) {
                 
                 
                 
                 return this.listaDeUsuarios.remove(usuarioBuffer);
                }
                
           }
        
       return false;
    }

}
