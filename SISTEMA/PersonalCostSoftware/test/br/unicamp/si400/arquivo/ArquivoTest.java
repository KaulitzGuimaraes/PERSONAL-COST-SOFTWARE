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
        //classe.create(u);
       
        Arquivo instance = new Arquivo();
        String[] c = new String[2];
        c[0] = "1000.00" ;
        c[1] = "24/10/2017";
        
         classe.retrieve(u[1]).getRendaMensal().create(c);
        
        String[] a = new String[7];
        a[0] = "Pao";
        a[1] = "Padaria";
        a[2] = "dinheiro";
        a[3] = "alimentacao";
        a[4] = "20.00";
        a[5] = "24/10/2017";
        a[6] = "12:30";
        classe.retrieve(u[1]).getGastos().create(a);
        u[0] = "Fulano";
        u[1] = "fulanes@hotmail.com";
        classe.create(u);
        classe.retrieve(u[1]).getRendaMensal().create(c);
         classe.retrieve(u[1]).getGastos().create(a);
        //String local, String formaDePagamento, double numeroValor, LocalDate data, LocalTime hora
        UsuariosDoSistema result = (UsuariosDoSistema) instance.load(classe);
        instance.save(classe);
        if (result ==  null){
            System.out.println( "Nao criou");
            fail("Falhou");
        }else{
            for (Usuario k : result.getUsuarioAtual()){
                System.out.println("\n"+result.retrieve(k.getEmail()).getEmail());
                System.out.println("\n"+result.retrieve(k.getEmail()).getRendaMensal().retrieve("24/10/2017").get(0).getNumeroValor());
               System.out.println(classe.retrieve(k.getEmail()).getGastos().retrieve("24/10/2017").get(0).getHora().toString());
            }
       
         instance.delete();
        }
    }
    
}
