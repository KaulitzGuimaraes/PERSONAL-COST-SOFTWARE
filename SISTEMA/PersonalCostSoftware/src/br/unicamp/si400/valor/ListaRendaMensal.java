/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.valor;

import br.unicamp.si400.crud.Crud;
import br.unicamp.si400.excecao.ExceptionDefault;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;
import java.util.TreeMap;

/**
 *
 * @author Kaulitz
 */
public class ListaRendaMensal extends ListaValor implements Crud {

    private TreeMap<String, ArrayList<RendaMensal>> listaRendaMensal;

    public ListaRendaMensal() {
        this.listaRendaMensal = new TreeMap();
        ArrayList<RendaMensal> j = new ArrayList();
        this.listaRendaMensal = new TreeMap();
        this.listaRendaMensal.put("janeiro", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("fevereiro", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("marco", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("abril", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("maio", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("junho", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("julho", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("agosto", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("setembro", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("outubro", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("novembro", (ArrayList<RendaMensal>) j.clone());
        this.listaRendaMensal.put("dezembro", (ArrayList<RendaMensal>) j.clone());
    }

    public TreeMap<String, ArrayList<RendaMensal>> getListaRendaMensal() {
        return listaRendaMensal;
    }

    @Override
    public boolean create(String[] data) throws ExceptionDefault {//double numeroValor, String tipo, String mes, String ano
        try {
            if (data != null && this.listaRendaMensal.containsKey(data[2])) {
                RendaMensal rendaMensalBuffer = new RendaMensal(Double.parseDouble(data[0]), data[1], data[2], data[3]);
                this.listaRendaMensal.get(data[2]).add(rendaMensalBuffer);
                return true;
            } else {
                throw new ExceptionDefault("Dados incorretos");
            }
        } catch (NullPointerException | NumberFormatException e) {
            throw new ExceptionDefault("Dados incorretos");
        }
    }

    @Override
    public ArrayList<RendaMensal> retrieve(String data) throws ExceptionDefault {
        try {
            if (this.listaRendaMensal.containsKey(data)) {

                return this.listaRendaMensal.get(data);

            } else {
                throw new ExceptionDefault("Dados incorretos");
            }
        } catch (NullPointerException e) {
            throw new ExceptionDefault("Dados incorretos");
        }
    }

    @Override
    public boolean update(String[] data) throws ExceptionDefault {

        try {
            if (this.listaRendaMensal.containsKey(data[0])) {
                Iterator <RendaMensal> iterator = this.listaRendaMensal.get(data[0]).iterator();
                while (iterator.hasNext()) {
                    if (iterator.next().getAno().equals(data[1]) & iterator.next().getMes().equals(data[0])) {
                        iterator.next().setNumeroValor(Double.parseDouble(data[2]));
                        return true;
                    }
                }

            } else {
                throw new ExceptionDefault("Dados incorretos");
            }
        } catch (NullPointerException | NumberFormatException e) {
            throw new ExceptionDefault("Nao foi possivel atualizar a renda mensal");
        }
        return false;
    }

    @Override
    public boolean delete(String data) throws ExceptionDefault {
        throw new UnsupportedOperationException("You can delete it!"); //To change body of generated methods, choose Tools | Templates.
    }

}
