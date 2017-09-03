/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;

import br.unicamp.si400.usuario.Usuario;
import java.util.Collection;
import java.util.LinkedList;


/**
 *
 * @author Kaulitz
 */
public  class ControleUsuario extends Controle implements Operacoes {
    private Usuario usuario;
    ControleUsuario(String nome, String email, String username,String senha ){
      String [] dados = {nome,email,username,senha};
      insert(dados);
    }
    ControleUsuario(Usuario usuario){
        this.usuario = usuario;
    }
    /**
     * 
     * @param dados 
     */
    @Override
    public void insert(String[] dados) {
        LinkedList listaBuffer = getListaUsuarios().getListaDeUsuarios();
        for(int i = 0;i < listaBuffer.size();i++){
            if (dados[3].equals(listaBuffer.get(i).toString())){
                System.err.println("Usuario ja existente");
            }
        }
        this.usuario = new Usuario(dados[0],dados[1],dados[3],dados[4]);
         getListaUsuarios().getListaDeUsuarios().add( usuario);
            
                
      
        
    }

    @Override
    public void delete(String [] dados) {
     if (this.usuario.getLogin().getSenha().equals(dados[1])){
         for(int i = 0;i <getListaUsuarios().getNumeroUsuarios() ;i++){
            if (dados[1].equals(getListaUsuarios().getListaDeUsuarios().get(i).toString())){
                getListaUsuarios().getListaDeUsuarios().remove(i);
            }
     }
     }
    
    }

    @Override
    public void retrieve(String[] dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void update(String[] dados) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
}
