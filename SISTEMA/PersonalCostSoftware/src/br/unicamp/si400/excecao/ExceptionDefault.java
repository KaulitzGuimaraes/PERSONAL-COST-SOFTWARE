/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.excecao;


import br.unicamp.si400.arquivo.Arquivo;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 * 
 * @author Kaulitz
 */
public class ExceptionDefault extends Exception{
    private static final Logger LOG = Logger.getLogger(Arquivo.class.getName());
    /**
     * Shows the message given when other class throws this error
     * @param mensagem 
     */
    public ExceptionDefault (String mensagem){
        JPanel n = new JPanel();
        ExceptionDefault ex = null ;
      
        LOG.log(Level.SEVERE, "exception default", this);
        
    }
}
