/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;
import java.util.TreeMap;

/**
 *
 * @author Kaulitz
 */
public class ListaRendaMensal implements Crud {
    
    private TreeMap<String,RendaMensal> listaRendaMensal;

    public ListaRendaMensal() {
        this.listaRendaMensal = new TreeMap();
        RendaMensal [] j = new RendaMensal[12];
        this.listaRendaMensal.put("janeiro", j[0]);
        this.listaRendaMensal.put("fevereiro", j[1]);
        this.listaRendaMensal.put("marco", j[2]);
        this.listaRendaMensal.put("abril", j[3]);
        this.listaRendaMensal.put("maio", j[4]);
        this.listaRendaMensal.put("junho", j[5]);
        this.listaRendaMensal.put("julho", j[6]);
        this.listaRendaMensal.put("agosto", j[7]);
        this.listaRendaMensal.put("setembro", j[8]);
        this.listaRendaMensal.put("outubro", j[9]);
        this.listaRendaMensal.put("novembro", j[10]);
        this.listaRendaMensal.put("dezembro", j[11]);
    }

    public TreeMap<String, RendaMensal> getListaRendaMensal() {
        return listaRendaMensal;
    }

    @Override
    public boolean create(String[] data)throws ExceptionDefault  {//double numeroValor, String tipo, String mes, String ano
        try{
       if(data != null && this.listaRendaMensal.containsKey(data[2])){
       RendaMensal rendaMensalBuffer = new RendaMensal(Double.parseDouble(data[0]),data[1],data[2],data[3]) ;
       this.listaRendaMensal.put(data[2], rendaMensalBuffer);
       return true;
       }else{
           throw new ExceptionDefault("Dados incorretos");
       }
        }catch (NullPointerException | NumberFormatException e) {
            throw new ExceptionDefault("Dados incorretos");
        }
    }

    @Override
    public RendaMensal retrieve(String data) throws ExceptionDefault {
     try{
       if(this.listaRendaMensal.containsKey(data)){
           
           return this.listaRendaMensal.get(data);
           
       }else{
           throw new ExceptionDefault("Dados incorretos");
       }
        }catch (NullPointerException e) {
            throw new ExceptionDefault("Dados incorretos");
        }
    }
    @Override
    public boolean update(String[] data) throws ExceptionDefault {
        try{
       if(this.listaRendaMensal.containsKey(data[0])){
           this.listaRendaMensal.get(data[0]).getNumeroValor(Double.parseDouble(data[1]));
           return this.listaRendaMensal.get(data);
           
       }else{
           throw new ExceptionDefault("Dados incorretos");
       }
        }catch (NullPointerException | NumberFormatException e) {
            throw new ExceptionDefault("Nao foi possivel atualizar a renda mensal");
        }
    }

    @Override
    public boolean delete(String data) throws ExceptionDefault {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
    
    
    
}
