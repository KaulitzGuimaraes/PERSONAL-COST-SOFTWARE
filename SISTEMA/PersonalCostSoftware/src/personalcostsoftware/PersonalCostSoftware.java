/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package personalcostsoftware;


import br.unicamp.si400.usuario.*;

/**
 *
 * @author Kaulitz
 */
public class PersonalCostSoftware {

    public PersonalCostSoftware() {
    }

   
 
   
    public void teste(){
        UsuariosDoSistema u = new  UsuariosDoSistema();
        String[] dados = new String[2];
        dados[0]= "Kau";
        dados[1]= "kaulitz@hotmail";
        if (u.create(dados)){
        System.out.println("inseriu");
        
    }
        dados[0]= "Kau";
        dados[1]= "kaulitz@gmail";
        if (u.create(dados)){
        System.out.println("inseriu");
        
    }
        dados[0]= "Kaulitz";
        dados[1]= "kaulitz@gma";
       //System.out.println(u.retrieve("kaulitz@gmail").getNome());
       if(u.update(dados)){
        System.out.println("atualizou");
         System.out.println(u.retrieve("kaulitz@gma").getNome());
       }
    }
    /**s
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
