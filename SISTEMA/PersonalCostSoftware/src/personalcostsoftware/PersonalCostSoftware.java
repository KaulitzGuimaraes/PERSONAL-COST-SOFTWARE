/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package personalcostsoftware;


import br.unicamp.si400.usuario.UsuariosDoSistema;
import java.util.Arrays;

/**
 *
 * @author Kaulitz
 */
public class PersonalCostSoftware {

    public PersonalCostSoftware() {
    }

   
 
   
    public void teste(){
             String novaSenha = "";
        for (int i=0; i<4; i++){
            Integer intBuffer = (int) (Math.random()*9);
            novaSenha = novaSenha + intBuffer.toString();
            System.out.println(novaSenha);
        }
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        // TODO code application logic here
      

        // TODO code application logic here     
        PersonalCostSoftware p = new PersonalCostSoftware();
        p.teste();
       

    }
    
   
    
}
