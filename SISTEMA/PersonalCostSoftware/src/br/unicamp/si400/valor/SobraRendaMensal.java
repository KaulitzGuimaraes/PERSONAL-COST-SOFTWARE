/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

/**
 *
 * @author Kaulitz
 */
public class SobraRendaMensal extends Valor{
    
    private final String mes;

    /**
     * Get the value of mes
     *
     * @return the value of mes
     */
    public String getMes() {
        return mes;
    }

    /**
     * Class constructor
     * 
     * @param numeroValor
     * @param tipo 
     * @param mes 
     */
    public SobraRendaMensal(long numeroValor, String tipo, String mes) {
        super(numeroValor, tipo);
         this.mes = mes;
        
    }
    
    
    
}
