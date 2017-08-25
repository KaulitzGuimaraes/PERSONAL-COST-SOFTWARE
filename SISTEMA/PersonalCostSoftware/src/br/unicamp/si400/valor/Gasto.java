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
public class Gasto extends Valor {
    
    private String descricao;
    
    private String local;
    
    private String formaDePagamento;
    
    /**
     * 
     * @param descricao
     * @param local
     * @param formaDePagamento
     * @param numeroValor
     * @param tipo 
     */

    public Gasto(String descricao, String local, String formaDePagamento, long numeroValor, String tipo) {
        super(numeroValor, tipo);
        this.descricao = descricao;
        this.local = local;
        this.formaDePagamento = formaDePagamento;
    }

  
    

    /**
     * Get the value of formaDePagamento
     *
     * @return the value of formaDePagamento
     */
    public String getFormaDePagamento() {
        return formaDePagamento;
    }

    /**
     * Set the value of formaDePagamento
     *
     * @param formaDePagamento new value of formaDePagamento
     */
    public void setFormaDePagamento(String formaDePagamento) {
        this.formaDePagamento = formaDePagamento;
    }

    
    

    /**
     * Get the value of local
     *
     * @return the value of local
     */
    public String getLocal() {
        return local;
    }

    /**
     * Set the value of local
     *
     * @param local new value of local
     */
    public void setLocal(String local) {
        this.local = local;
    }


    /**
     * Get the value of descricao
     *
     * @return the value of descricao
     */
    public String getDescricao() {
        return descricao;
    }

    /**
     * Set the value of descricao
     *
     * @param descricao new value of descricao
     */
    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    
    
}
