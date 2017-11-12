/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;

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
public class ControlTest {
    
    public ControlTest() {
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
     * Test of control method, of class Control.
     */
    @Test
    public void testControl() {
        System.out.println("control");
        Control expResult = null;
        Control result = Control.control();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of saveData method, of class Control.
     */
    @Test
    public void testSaveData() {
        System.out.println("saveData");
        Control instance = null;
        instance.saveData();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of loginUser method, of class Control.
     */
    @Test
    public void testLoginUser() throws Exception {
        System.out.println("loginUser");
        String email = "";
        char[] senha = null;
        Control instance = null;
        instance.loginUser(email, senha);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of newUser method, of class Control.
     */
    @Test
    public void testNewUser() throws Exception {
        System.out.println("newUser");
        String email = "kau";
        String name = "kau";
        String question = "q";
        String answer = "q";
        char[] password =  new char[1];
         password[0]= '1';
        char[] cpassword = new char[1];
        cpassword[0] = '1';
        Control.control().newUser(email, name, question, answer, password, cpassword);
        // TODO review the generated test code and remove the default call to fail.
        
    }
    
}
