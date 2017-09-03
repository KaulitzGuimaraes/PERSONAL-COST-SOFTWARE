/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;

import br.unicamp.si400.usuario.Usuario;
import java.util.LinkedList;

/**
 *
 * @author Kaulitz
 */
public class ControleUsuario extends Controle implements Operacoes {
    
    /**
     * 
     * @param dados 
     */
    @Override
    public void insert(String[] dados) {
       Usuario novousuario;
        novousuario = new Usuario(dados[0],dados[1],dados[3],dados[4]);
    }

    @Override
    public void delete(String chaveDelete) {
        int i =0;
        int tamanhoListaUsuario = super.getUsuario().size();
        if (super.getUsuario().isEmpty()){
                System.out.println("Não há usuários");
            } else{
        while (i< tamanhoListaUsuario){
             if (chaveDelete.equals(super.getUsuario().get(i).toString())){
                super.getUsuario().remove(i);
            }
        }
        }
        if(i>=tamanhoListaUsuario){
                System.out.println("Usuário não encontrado");
            }
{
        
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
