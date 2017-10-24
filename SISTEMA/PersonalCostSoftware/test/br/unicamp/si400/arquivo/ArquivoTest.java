/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.arquivo;

import br.unicamp.si400.excecao.ExceptionDefault;
import br.unicamp.si400.usuario.Usuario;
import br.unicamp.si400.usuario.UsuariosDoSistema;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
        String[] c = new String[2];
        c[0] = "1000.00" ;
        c[1] = "24/10/2017";
         classe.retrieve(u[1]).getRendaMensal().create(c);
         instance.save(classe);
        UsuariosDoSistema result = (UsuariosDoSistema) instance.load(classe);
        
        if (result ==  null){
            System.out.println( "Nao criou");
            fail("Falhou");
        }else{
        System.out.println("\n"+result.retrieve(u[1]).getEmail());
        System.out.println("\n"+result.retrieve(u[1]).getRendaMensal().retrieve("24/10/2017").get(0).getNumeroValor());
         instance.delete();
        }
    }
    
}
