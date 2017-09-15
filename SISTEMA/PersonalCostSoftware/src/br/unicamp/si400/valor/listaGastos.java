/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.crud.Crud;
import java.util.ArrayList;
import java.util.TreeMap;

/**
 *
 * @author Kaulitz
 */
public class listaGastos implements Crud{
   
    private TreeMap <String,ArrayList> listaGastos;
    /**
     * Class constructor
     */
    public listaGastos() {
        this.listaGastos = new TreeMap() ;
    }
    
    
    @Override
    public boolean create(String[] data) {
        Gasto gastoBuffer = new Gasto(data[1],data[2],data[3],Long.parseLong(data[4]),data[5]);
        if( !this.listaGastos.isEmpty() || !this.listaGastos.containsKey(data[0])){
        ArrayList <Gasto> gastosBuffer = new ArrayList();
        boolean b = gastosBuffer.add(gastoBuffer);
         this.listaGastos.put(data[0],gastosBuffer);
         return b;
        }else{
           return this.listaGastos.get(data[0]).add(gastoBuffer);
        }
        
        }

    @Override
    public ArrayList retrieve(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean update(String[] data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String data) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
        
    

    
}
