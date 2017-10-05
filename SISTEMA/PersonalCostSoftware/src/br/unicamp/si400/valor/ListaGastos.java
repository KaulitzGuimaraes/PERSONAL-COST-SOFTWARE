/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableSet;
import java.util.Set;
import java.util.TreeMap;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Kaulitz
 */
public class ListaGastos implements Crud {

    private TreeMap<String, ArrayList<Gasto>> listaGastos;

    /**
     * Class constructor
     */
    public ListaGastos() {
        ArrayList<Gasto> j = new ArrayList();
        this.listaGastos = new TreeMap();
        this.listaGastos.put("janeiro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("fevereiro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("marco", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("abril", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("maio", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("junho", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("julho", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("agosto", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("setembro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("outubro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("novembro", (ArrayList<Gasto>) j.clone());
        this.listaGastos.put("dezembro", (ArrayList<Gasto>) j.clone());
        
    }

    @Override
    public boolean create(String[] data) throws ExceptionDefault {

        try {//String descricao, String local, String formaDePagamento, String horaDoGasto, String diaDoGasto, String mesDoGasto, String anoDoGasto, long numeroValor, String tipo

            Gasto gastoBuffer = new Gasto(data[0], data[1], data[2], Double.parseDouble(data[3]), data[4], data[5], data[6],
                    data[7], data[8]);
            this.listaGastos.get(data[6]).add(gastoBuffer);
            return true;
        } catch (NullPointerException | NumberFormatException e) {
            throw new ExceptionDefault("Não foi adicionar os gastos");
        }
    }

    @Override
    public ArrayList retrieve(String data) throws ExceptionDefault {
        try {
            return this.listaGastos.get(data);
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Não foi recuperar os gastos");

        }

    }

    @Override
    public boolean update(String[] data) {
        throw new UnsupportedOperationException("You can't update a cost"); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public boolean delete(String data) throws ExceptionDefault {
        try {
            this.listaGastos.remove(data);
            return true;
        } catch (NullPointerException e) {

            throw new ExceptionDefault("Não foi deletar os gastos");

        }

    }

    public boolean delete(String data[]) throws ExceptionDefault {
        try {//String descricao, String local, String formaDePagamento, String horaDoGasto, String diaDoGasto, String mesDoGasto, String anoDoGasto, long numeroValor, String tipo
            Gasto gastoBuffer = new Gasto(data[0], data[1], data[2], Double.parseDouble(data[3]), data[4], data[5], data[6],
                    data[7], data[8]);
            return this.listaGastos.get(data[6]).remove(gastoBuffer);
        } catch (NullPointerException | NumberFormatException e) {
            throw new ExceptionDefault("Não foi deletar os gastos");
        }

    }

    public double SomaValores(String ano) throws ExceptionDefault {
        try {
            TreeMap<String, ArrayList<Gasto>> mapBuffer = new TreeMap(this.listaGastos);
            double result = 0;
            Set<String> keys = mapBuffer.keySet();
            for (String key : keys) {
                result += SomaValores(key, ano);
            }

            return result;
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Dados incorretos");
        }
    }

    public double SomaValores(String mes, String ano) throws ExceptionDefault {
        try {
            ArrayList<Gasto> arrayListBuffer = new ArrayList(this.listaGastos.get(mes));
            double result = 0;
            for (Gasto el : arrayListBuffer) {
                if (el.getMes().equals(mes) & el.getAno().equals(ano)) {
                    result += el.getNumeroValor();
                }
            }

            return result;
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Dados incorretos");
        }
    }

    public double SomaValores(String dia, String mes, String ano) throws ExceptionDefault {
        try {
            ArrayList<Gasto> arrayListBuffer = new ArrayList(this.listaGastos.get(mes));
            double result = 0;
            for (Gasto el : arrayListBuffer) {
                if (el.getDia().equals(dia) & el.getMes().equals(mes) & el.getAno().equals(ano)) {
                    result += el.getNumeroValor();
                }
            }
            return result;
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Dados incorretos");
        }

    }

}
