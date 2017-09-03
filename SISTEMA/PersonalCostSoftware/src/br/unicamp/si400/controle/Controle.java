/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;
import br.unicamp.si400.usuario.Usuario;
import br.unicamp.si400.valor.*;
import java.util.LinkedList;


/**
 *
 * @author Kaulitz
 */
public class Controle {
    private LinkedList  usuario;
    private RendaMensal rendaMensalUsuario;
    private Gasto gastoUsuario;
    private SobraRendaMensal sobraRendaMensalUsuario;
    /**
     * 
     * @return 
     */
    public LinkedList getUsuario() {
        return usuario;
    }
    /**
     * 
     * @param usuario
     * 
     */
    public void setUsuario(Usuario usuario) {
        this.usuario.add(usuario);
    }
    /**
     * 
     * @return 
     */
    public RendaMensal getRendaMensalUsuario() {
        return rendaMensalUsuario;
    }
    /**
     * 
     * @param rendaMensalUsuario 
     */
    public void setRendaMensalUsuario(RendaMensal rendaMensalUsuario) {
        this.rendaMensalUsuario = rendaMensalUsuario;
    }
    /**
     * 
     * @return 
     */
    public Gasto getGastoUsuario() {
        return gastoUsuario;
    }
    /**
     * 
     * @param gastoUsuario 
     */
    public void setGastoUsuario(Gasto gastoUsuario) {
        this.gastoUsuario = gastoUsuario;
    }
    /**
     * 
     * @return 
     */
    public SobraRendaMensal getSobraRendaMensalUsuario() {
        return sobraRendaMensalUsuario;
    }
    /**
     * 
     * @param sobraRendaMensalUsuario 
     */
    public void setSobraRendaMensalUsuario(SobraRendaMensal sobraRendaMensalUsuario) {
        this.sobraRendaMensalUsuario = sobraRendaMensalUsuario;
    }
    
    
}
