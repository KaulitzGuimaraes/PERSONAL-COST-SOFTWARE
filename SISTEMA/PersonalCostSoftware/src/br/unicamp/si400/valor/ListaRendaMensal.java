/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;
import com.sun.org.apache.xalan.internal.xsltc.compiler.Template;
import java.io.Serializable;
import java.time.LocalDate;
import java.time.Month;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Kaulitz
 */
public class ListaRendaMensal extends ListaValor implements Crud,Serializable {

    private TreeMap<Month, ArrayList<RendaMensal>> listaRendaMensal;

    public ListaRendaMensal() {
        this.listaRendaMensal = new TreeMap();
        ArrayList<RendaMensal> j = new ArrayList();
        this.listaRendaMensal = new TreeMap();
        this.listaRendaMensal.put(Month.JANUARY, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.FEBRUARY, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.MARCH, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.APRIL, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.MAY, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.JUNE, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.JULY, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.AUGUST, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.SEPTEMBER, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.OCTOBER, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.NOVEMBER, (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put(Month.DECEMBER, (ArrayList<RendaMensal>) j.clone());
        
    }

   

    /**
     *
     * @param data
     * @return boolean
     * @throws ExceptionDefault
     */
    @Override
    public boolean create(String[] data) throws ExceptionDefault {//double numeroValor, String tipo, LocalDate
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d =  LocalDate.parse(data[1], format);
            if (data != null &&  this.listaRendaMensal.containsKey(d.getMonth())) {
                RendaMensal rendaMensalBuffer = new RendaMensal(Double.parseDouble(data[0]),d);
                this.listaRendaMensal.get(d.getMonth()).add(rendaMensalBuffer);
                return true;
            } else {
                throw new ExceptionDefault("Dados incorretos");
            }
        } catch (NullPointerException | NumberFormatException | DateTimeParseException e) {
            throw new ExceptionDefault("Dados incorretos " +  e.getClass());
        }
    }

    /**
     *
     * @param data
     * @return
     * @throws ExceptionDefault
     */
    @Override
    public ArrayList<RendaMensal> retrieve(String data) throws ExceptionDefault {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d = LocalDate.parse(data, format);
            return this.listaRendaMensal.get(d.getMonth()) ;
                
                
          
        } catch (NullPointerException | DateTimeParseException e) {
            throw new ExceptionDefault("Dados incorretos");
        }
    }

    /**
     *
     * @param data
     * @return
     * @throws ExceptionDefault
     */
    @Override
    public boolean update(String[] data) throws ExceptionDefault {

        try {
            
                for (RendaMensal el : this.listaRendaMensal.get(LocalDate.parse(data[1].subSequence(0,data[1].length()-1)).getMonth())) {
                    if (LocalDate.parse(data[1].subSequence(0, data[1].length()-1)).getYear() == el.getData().getYear()){
                        
                        this.listaRendaMensal.get(LocalDate.parse(data[1].subSequence(0,data[1].length()-1)).getMonth()).remove(el);
                        el.setNumeroValor(Double.parseDouble(data[0]));
                         return this.listaRendaMensal.get(LocalDate.parse(data[1].subSequence(0,data[1].length()-1)).getMonth()).add(el);
                       
                    } else {
                        
                        return false;
                    }
                }
               
        } catch (NullPointerException | NumberFormatException | DateTimeParseException e) {
            throw new ExceptionDefault("Nao foi possivel atualizar a renda mensal");
        }
        return false;
    }

    /**
     *
     * @param data
     * @return
     * @throws ExceptionDefault
     */
    @Override
    public boolean delete(String data) throws ExceptionDefault {
        throw new UnsupportedOperationException("You can delete it!"); //To change body of generated methods, choose Tools | Templates.
    }

}
