/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.arquivo;

import br.unicamp.si400.excecao.ExceptionDefault;
import br.unicamp.si400.usuario.Usuario;
import br.unicamp.si400.usuario.UsuariosDoSistema;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Kaulitz
 */
public class ArquivoTest {
    
    public ArquivoTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of load method, of class Arquivo.
     */
    @Test
    public void testLoad() throws ExceptionDefault {
        System.out.println("load");
        UsuariosDoSistema classe = new UsuariosDoSistema();
        String[] u = new String[2];
        u[0] = "Kau";
        u[1] = "kaulitzguimaraes@hotmail.com";
        
        classe.create(u);
        Arquivo instance = new Arquivo();
        
         instance.save(classe);
        UsuariosDoSistema result = (UsuariosDoSistema) instance.load(classe);
        
        if (result ==  null){
            System.out.println( "Nao criou");
        }else{
        System.out.println("\n"+result.retrieve(u[1]).getEmail());
         instance.delete();
        }
    }
    
}
