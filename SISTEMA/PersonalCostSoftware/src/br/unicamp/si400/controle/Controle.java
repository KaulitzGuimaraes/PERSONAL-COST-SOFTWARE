/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;
import br.unicamp.si400.usuario.*;
import br.unicamp.si400.valor.*;


/**
 *
 * @author Kaulitz
 */
public class Controle {

    private UsuariosDoSistema listaUsuarios =  new UsuariosDoSistema(); 
   

    /**
     * 
     * @return 
     */
     public UsuariosDoSistema getListaUsuarios() {
        return listaUsuarios;
    }
}
