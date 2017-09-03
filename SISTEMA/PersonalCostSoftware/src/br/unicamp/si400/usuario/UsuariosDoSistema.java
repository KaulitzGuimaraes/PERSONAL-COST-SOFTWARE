/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.usuario;

import java.util.LinkedList;

/**
 *
 * @author Kaulitz
 */
public class UsuariosDoSistema {
    LinkedList listaDeUsuarios = new LinkedList();

     public LinkedList getListaDeUsuarios() {
        return listaDeUsuarios;
    }

    public void setListaDeUsuarios(LinkedList listaDeUsuarios) {
        this.listaDeUsuarios = listaDeUsuarios;
    }
    
    public int getNumeroUsuarios(){
        if (listaDeUsuarios.isEmpty()){
            return 0;
        }else{
            return listaDeUsuarios.size();
        }
    }
    
}
