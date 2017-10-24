/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.arquivo;

import br.unicamp.si400.usuario.Usuario;
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
    public void testLoad() {
        System.out.println("load");
        Usuario classe = new Usuario("Kau", "kaulitzguimaraes@hotmail.com");
        Arquivo instance = new Arquivo("teste.dat");
        Usuario result = (Usuario) instance.load(classe);
        System.out.println( result.getEmail());
    }
    
}
