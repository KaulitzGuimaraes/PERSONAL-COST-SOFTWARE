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

   
 
   
    public void testeLogin(){
            UsuariosDoSistema u = new UsuariosDoSistema();
            String[] s = new String[4];
            s[0] = "Kau";
            s[1] =  "kaulitzguimaraes@hotmail.com";
            s[2] = "TokiJ";
            u.novoUsuario(s);
            System.out.println(Arrays.toString(u.recuperarDadosUsuario(s[1])));
            String[] s2 = new String[4];
            s2[0] = "kaulitzguimaraes@hotmail.com";
            s2[1] =  "TOKIOHOTAAl";
            u.atualizarDadosUsuario(s2);
           u.deletarUsuario(s2);
           System.out.println(Arrays.toString(u.recuperarDadosUsuario(s[1])));
    }
    /**
     *
     * @param args
     */
    public static void main(String[] args) {

        // TODO code application logic here
      

        // TODO code application logic here     
        PersonalCostSoftware p = new PersonalCostSoftware();
        p.testeLogin();
       

    }
    
   
    
}
