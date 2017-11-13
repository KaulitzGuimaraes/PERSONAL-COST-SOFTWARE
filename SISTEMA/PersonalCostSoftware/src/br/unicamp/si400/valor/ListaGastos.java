/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.excecao.ExceptionDefault;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.TreeMap;

/**
 *
 * @author Kaulitz
 */
public class ListaGastos extends ListaValor implements Serializable  {

    private  TreeMap<Month, ArrayList<Gasto>> listaGastos;

    /**
     * Class constructor
     */
    public ListaGastos() {
        ArrayList<Gasto> j = new ArrayList();
        this.listaGastos = new TreeMap();
        this.listaGastos.put(Month.JANUARY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.FEBRUARY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.MARCH, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.APRIL, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.MAY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.JUNE, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.JULY, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.AUGUST, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.SEPTEMBER, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.OCTOBER, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.NOVEMBER, (ArrayList<Gasto>) j.clone());
        this.listaGastos.put(Month.DECEMBER, (ArrayList<Gasto>) j.clone());
        
    }
    /**
     * This method receives a String array and 
     *creates a new Gasto object, then this new object
     * is placed in the class Map.
     * @param data
     * @return boolean
     * 
     */
    @Override
    public boolean create(String[] data) {

        try {//String local, String formaDePagamento, double numeroValor, LocalDate data, LocalTime hora
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH:mm");
            LocalDate d = LocalDate.parse(data[5], format);
            LocalTime t = LocalTime.parse(data[6], format1);
            Gasto gastoBuffer = new Gasto(data[0], data[1], data[2], data[3], Double.parseDouble(data[4]),d,t );
            return this.listaGastos.get(d.getMonth()).add(gastoBuffer);
            
          
        } catch (NullPointerException | NumberFormatException|DateTimeParseException   e) {
             return false;
        }
    }
    /**
     * This method retrieves the Array list that corresponds
     * to the key received.
     * @param data
     * @return ArrayList
     * @throws ExceptionDefault 
     */
    @Override
    public ArrayList<Gasto> retrieve(String data) throws ExceptionDefault {
        try {
           
            
            return this.listaGastos.get(Month.valueOf(data));
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Não foi recuperar os gastos");

        }

    }
    /**
     * This method is not supported. 
     * @param data
     * @return 
     */
    @Override
    public boolean update(String[] data) {
        throw new UnsupportedOperationException("You can't update a cost"); //To change body of generated methods, choose Tools | Templates.
    }
    /**
     * This method clear the Array list that corresponds
     * the key received.
     * @param data
     * @return boolean
     * @throws ExceptionDefault 
     */
    @Override
    public boolean delete(String data) throws ExceptionDefault {
        try {
            this.listaGastos.get(data).clear();
            return true;
        } catch (NullPointerException e) {

            throw new ExceptionDefault("Não foi deletar os gastos");

        }

    }
    /**
     * delete a specific object Gasto that is 
     * into the ArrayList at the specific key 
     * received.
     * @param data
     * @return
     * @throws ExceptionDefault 
     */
    public boolean delete(String data[]) throws ExceptionDefault {
        try {//String descricao, String local, String formaDePagamento, String tipo, double numeroValor, LocalDate data, LocalTime hora
            
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            DateTimeFormatter format1 = DateTimeFormatter.ofPattern("HH:mm");
            LocalDate d = LocalDate.parse(data[5], format);
            LocalTime t = LocalTime.parse(data[6], format1);
            Gasto gastoBuffer = new Gasto(data[0], data[1], data[2],data[3],Double.parseDouble(data[4]),d,t);
            Iterator <Gasto> n = this.listaGastos.get(d.getMonth()).listIterator();
            while(n.hasNext()){
                 Gasto g = n.next();
                if (g.getDescricao().equals(data[0]) & g.getLocal().equals(data[1]) &  g.getFormaDePagamento().equals(data[2]) & g.getTipo().equals(data[3])
                  & g.getNumeroValor() == Double.parseDouble(data[4]) &  g.getData().equals(d) & g.getHora().equals(t)    ){
                     n.remove();
                     return true;
                }
           }
            return false;
           
        } catch (NullPointerException | NumberFormatException | DateTimeParseException e) {
           return false;
        }

    }
    
    public boolean isListEmpty(){
        for ( Month s : this.listaGastos.keySet()){
            
            if(!this.listaGastos.get(s).isEmpty()){
                return false;
            }
        }
        return true;
    }

}
