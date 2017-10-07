/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package personalcostsoftware;


import br.unicamp.si400.excecao.ExceptionDefault;
import br.unicamp.si400.usuario.*;

/**
 *
 * @author Kaulitz
 */
public class PersonalCostSoftware {

    public PersonalCostSoftware() {
    }

   
 
   
    public void teste() throws ExceptionDefault{
        UsuariosDoSistema u = new  UsuariosDoSistema();
        String[] dados = new String[2];
        dados[0]= "Kau";
        dados[1]= "kaulitz@hotmail";
        
        
    
        dados[0]= "Kau";
        dados[1]= "kaulitz@gmail";
        //u.create(null);
        System.out.println("inseriu");
        
    
        dados[0]= "Kaulitz";
        dados[1]= "kaulitz@gmai";
      try{
       if(u.update(dados))
        System.out.println("atualizou");
         System.out.println(u.retrieve("kaulitz@gma").getNome());
       
       }catch(NullPointerException e){
           System.err.println("Usuario " + dados[1] + " Nao existe");
       }
    }
    /**s
     *
     * @param args
     */
    public static void main(String[] args) throws ExceptionDefault {

        // TODO code application logic here
      

        // TODO code application logic here     
        PersonalCostSoftware p = new PersonalCostSoftware();
        p.teste();
       

    }
    
   
    
}
