/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

import java.util.ArrayList;

/**
 *
 * @author Kaulitz
 */
public class UsuariosDoSistema implements UsuarioModel{
    ArrayList <Usuario> listaDeUsuarios;

     public ArrayList getListaDeUsuarios() {
        return listaDeUsuarios;
    }

  
    
    public int getNumeroUsuarios(){
        if (listaDeUsuarios.isEmpty()){
            return 0;
        }else{
            return listaDeUsuarios.size();
        }
    }
    /**
     * 
     * @param dados 
     */
    @Override
    public void novoUsuario(String dados[]) {
         if(!checarListaUsuario(dados[1])){
             Usuario usuarioBuffer = new Usuario(dados[0],dados[1],dados[3]);
             listaDeUsuarios.add(usuarioBuffer);
         }else{
             System.err.println("Usuario ja existente");
         }
    }
    /**
     * 
     * @param dado
     * @return 
     */
    @Override
    public boolean checarListaUsuario(String dado) {
        int nUsuarios =getNumeroUsuarios();
         if(nUsuarios>0){
             for (Usuario u :this.listaDeUsuarios){
                 if(u.getEmail().equals(dado) ){
                     return true;
                 }
                 
             }
             
         }
        return false;
    }
    /**
     * 
     * @param dados 
     */
    @Override
    public void atualizarDadosUsuario(String[] dados) {
        String[] u  =recuperarDadosUsuario(dados[0]);
       if(u != null){
            this.listaDeUsuarios.get(Integer.parseInt(u[0])).getLogin().setSenha(dados[1]);
            
       }else{
           System.err.println("Usuario não existe");
       }
    }

    @Override
    public void deletarUsuario(String[] dados) {
        
        String[] u  =recuperarDadosUsuario(dados[0]);
        if(u != null){
            this.listaDeUsuarios.remove(Integer.parseInt(u[0]));
            
       }else{
           System.err.println("Usuario não existe");
       }
    }

    @Override
    @SuppressWarnings("empty-statement")
    public String[] recuperarDadosUsuario(String dado) {
        int nUsuarios =getNumeroUsuarios();
        int i =0;
        String[] dados = new String[3];
         if(nUsuarios>0){
             for (Usuario u :this.listaDeUsuarios){
                 if(u.getEmail().equals(dado) ){
                     dados[0] = Integer.toString(i);
                     dados[1] = u.getEmail();
                     dados[2] =u.getLogin().getSenha();
                     return dados; 
                 }else{
                  i++;
                }
                 
             }
             
         }
        return null;
        
    }

   
    
}
