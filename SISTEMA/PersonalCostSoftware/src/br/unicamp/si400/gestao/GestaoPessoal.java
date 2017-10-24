/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.gestao;

/**
 *
 * @author Kaulitz
 */
public class GestaoPessoal {

    private  double resultado;

    public GestaoPessoal() {
        this.resultado = 0;
    }

    public double valorRestante(double minuendo, double subtraendo) {

        this.resultado = minuendo - subtraendo;

        return  this.resultado;
    }
    
    public double valorRestantePorcentagem(double minuendo, double subtraendo) {

        this.resultado = ((minuendo - subtraendo)/minuendo)*100 ;
        
        return  this.resultado;
        
        
    }
    
    public Double valorSomado(double data[]) {
         double buffer =0;
         
       
        
         for (double el : data){
            buffer += el;
            
        }
          this.resultado =  buffer;
        return (Double) this.resultado;
    }
    
    public Double mediaValores(double[] data){
        double buffer =valorSomado(data);
       
        this.resultado = (Double) buffer/(data.length);
        return (Double) this.resultado;
        
    }
    
    public Double varianciaValores(double[] data){
        double media = mediaValores(data);
        double buffer =0;
        for (double el : data){
            buffer += Math.pow(el, 2);
            
        }
        
        this.resultado = (Double) (buffer/ data.length) - Math.pow(media, 2) ;
        return (Double) this.resultado;
        
    }
    
    
    public Double desvioPadraoValores(double[] data){
        double variancia = varianciaValores(data);
        
        
        this.resultado = (Double) Math.sqrt(variancia) ;
        return (Double) this.resultado;
        
    }
    public Object getResultado() {
        return resultado;
    }

}
