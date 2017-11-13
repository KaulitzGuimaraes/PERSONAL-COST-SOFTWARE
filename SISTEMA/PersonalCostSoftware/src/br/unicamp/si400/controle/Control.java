/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;

import br.unicamp.si400.arquivo.Ar;
import br.unicamp.si400.excecao.ExceptionDefault;
import br.unicamp.si400.gestao.GestaoPessoal;
import br.unicamp.si400.interfaces.Menu;
import br.unicamp.si400.interfaces.MenuUsuario;
import br.unicamp.si400.usuario.Usuario;
import br.unicamp.si400.usuario.UsuariosDoSistema;
import br.unicamp.si400.valor.Gasto;
import br.unicamp.si400.valor.ListaGastos;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;
import java.util.TreeMap;
import javax.swing.JOptionPane;

/**
 *
 * @author Kaulitz
 */
public class Control {

    private Ar data;
    private UsuariosDoSistema users;
    private Usuario user;

    private static Control control;

    private Control() {
        this.data = new Ar();
        this.users = new UsuariosDoSistema();

    }

    /**
     * Constructor Sigleton patter
     *
     * @return
     */
    public static Control control() {
        if (control == null) {
            control = new Control();
        }
        return control;
    }

    /**
     * Load fata from a archive
     *
     * @throws java.io.IOException
     */
    public void loadData() throws IOException {

        this.users = new UsuariosDoSistema();
        this.users = (UsuariosDoSistema) this.data.load(this.users);

    }

    /**
     * Save data in the archive
     */
    public void saveData() {
        data.save(this.users);
    }

    /**
     * Receive the email and the password, check if os compatible then
     * effectives the login. If isn't compatible it shows a message.
     *
     * @param email
     * @param senha
     * @throws ExceptionDefault
     * @throws java.io.IOException
     */
    public void loginUser(String email, char[] senha) throws ExceptionDefault, IOException {
        try {
            this.user = this.users.retrieve(email);
            boolean password = this.user.getLogin().retrieve(String.valueOf(senha));
            if (!password) {
                JOptionPane.showMessageDialog(Menu.menu(), "Senha incorreta.");
            } else {
                JOptionPane.showMessageDialog(Menu.menu(), "Login Realizado com sucesso.");
                Menu.menu().setVisible(false);
                MenuUsuario.menuUsuario().init();
                MenuUsuario.menuUsuario().setVisible(true);

            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(Menu.menu(), "Usuario inexistente ou incorreto");
        }

    }

    /**
     * Create a new user receiving the data. If isn't possible to create, it
     * shows a message.
     *
     * @param email
     * @param name
     * @param question
     * @param answer
     * @param password
     * @param cpassword
     * @throws ExceptionDefault
     * @throws java.io.IOException
     */
    public void newUser(String email, String name, String question, String answer, char[] password, char[] cpassword) throws ExceptionDefault, IOException {

        try {
            if (String.valueOf(password).equals(String.valueOf(cpassword))) {
                String[] userData = new String[2];
                userData[0] = name;
                userData[1] = email;
                String[] loginData = new String[3];
                loginData[0] = String.valueOf(password);
                loginData[1] = question;
                loginData[2] = answer;
                boolean newInstance1 = control.users.create(userData);

                boolean newInstance2 = control.users.retrieve(email).getLogin().create(loginData);

                if (newInstance1 & newInstance2) {
                    control.saveData();
                    JOptionPane.showMessageDialog(Menu.menu(), "Usuario cadastrado com sucesso");
                } else {
                    JOptionPane.showMessageDialog(Menu.menu(), "Usuario já cadastrado");
                }
            } else {
                JOptionPane.showMessageDialog(Menu.menu(), "Senhas não correspondem");
            }
        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(Menu.menu(), "Nao foi possivel cadastrar o usuario");

        }
    }

    /**
     *
     * Switch the password if the user give the right secret answer for his
     * question.
     *
     * @param email
     * @throws ExceptionDefault
     */
    public void forgotPassword(String email) throws ExceptionDefault, IOException {

        try {
            Usuario buffer = control().users.retrieve(email);
            String question = buffer.getLogin().getPerguntaSecreta();
            String answer = JOptionPane.showInputDialog("Digite a resposta para a sua pergunta secreta :" + "\n" + question);
            if (buffer.getLogin().getRespostaSecreta(answer)) {

                String novaSenha = control().users.retrieve(email).getLogin().esqueceuSenha();
                JOptionPane.showMessageDialog(Menu.menu(), "Sua senha nova senha é :\n" + novaSenha);
                control().saveData();

            } else {
                JOptionPane.showMessageDialog(Menu.menu(), "resposta incorreta");
            }
        } catch (NullPointerException e) {

            JOptionPane.showMessageDialog(Menu.menu(), "Usuário incorreto e inexistente");

        }

    }

    /**
     * Change the user Password .
     *
     * @param password
     * @param confirmpassword
     * @throws ExceptionDefault
     */
    public void changePassword(char[] password, char[] confirmpassword) throws ExceptionDefault, IOException {
        String pass = String.valueOf(password);
        String cpass = String.valueOf(confirmpassword);
        if (pass.equals(cpass)) {
            String[] passwordS = new String[1];
            passwordS[0] = pass;
            control().users.retrieve(control().user.getEmail()).getLogin().update(passwordS);
            JOptionPane.showMessageDialog(Menu.menu(), "Senha alterada com sucesso");
            control().saveData();
        } else {
            JOptionPane.showMessageDialog(Menu.menu(), "Senhas não correspondem");
        }
    }

    /**
     * Load the Info field from userMenu data .
     *
     * @return @throws ExceptionDefault
     * @throws IOException
     */
    public List<String> setInfoHome() throws ExceptionDefault, IOException {
        List<String> listInfo = new ArrayList();

        
        listInfo.add(formatNumer(totalCostMonth(LocalDate.now())));
        listInfo.add(formatNumer(totalCostYear(LocalDate.now())));
        
        listInfo.add(formatNumer(totalAverageMonth(LocalDate.now())));
        listInfo.add(totalAverageYear(LocalDate.now()));
        listInfo.add(mostSCost(LocalDate.now(), loadListType()));
        return listInfo;

    }
    /**
     * Convert string to double
     * @param v 
     */
    
    private String formatNumer(String v){
        NumberFormat formatter = new DecimalFormat("###.##");
        String s3 ; 
        s3 = formatter.format(Double.parseDouble(v));
        s3 = s3.replace(",", ".");
        return s3;
    }
    /**
     * Load a list of types from a file in txt
     *
     * @return @throws IOException
     */
    public List<String> loadListType() throws IOException {

        return loadList("TypeList.txt");
    }

    /**
     * Load a list of payments from a file in txt
     *
     * @return @throws java.io.IOException
     */
    public List<String> loadListPayment() throws IOException {

        return loadList("PaymentList.txt");
    }

    /**
     * load a list by a file name given.
     *
     * @param fileName
     * @return
     * @throws IOException
     */
    private List<String> loadList(String fileName) throws IOException {
        File file = new File(fileName);

        List<String> words = Files.readAllLines(file.toPath());

        return words;

    }

    /**
     * Calculate the total cost of an especific Month.
     *
     * @param e
     * @return
     * @throws ExceptionDefault
     */
    public String totalCostMonth(LocalDate e) throws ExceptionDefault {
        ListaGastos list = control().user.getGastos();

        list.retrieve(e.getMonth().toString());
        ArrayList<Double> list3 = new ArrayList();
        if (!list.retrieve(e.getMonth().toString()).isEmpty()) {

            for (Gasto n : list.retrieve(e.getMonth().toString())) {
                if (n.getData().getYear() == e.getYear()) {
                    list3.add(n.getNumeroValor());
                }
            }

            return Double.toString(sumValues(list3));
        } else {
            return "0.0";
        }
    }

    /**
     * Calculate the total cost of an especific year.
     *
     * @param e
     * @return
     * @throws ExceptionDefault
     */
    private String totalCostYear(LocalDate e) throws ExceptionDefault {
        ArrayList<Double> list3 = new ArrayList();
        for (Month n : Month.values()) {

            list3.add(Double.parseDouble(totalCostMonth(e.withMonth(n.getValue()))));
        }

        return Double.toString(sumValues(list3));

    }

    /**
     * Look for the type cost that shows up the most.
     *
     * @param e
     * @param typeList
     * @return
     * @throws ExceptionDefault
     */
    private String mostSCost(LocalDate e, List<String> typeList) throws ExceptionDefault {
        ListaGastos list = control().user.getGastos();
        TreeMap<String, Integer> count = new TreeMap();
        if (!this.user.getGastos().isListEmpty()) {
            typeList.forEach((el) -> {
                count.put(el, 0);
            });
            for (Month m : Month.values()) {

                for (Gasto n : list.retrieve(m.toString())) {
                    if (n.getData().getYear() == LocalDate.now().getYear()) {
                        if (count.containsKey(n.getTipo())) {
                            Integer v = count.get(n.getTipo());
                            v++;
                            count.replace(n.getTipo(), v);
                        }
                    }
                }
            }

            LinkedList<Integer> l = new LinkedList();
          
            for (String el : count.keySet()) {
                l.add(count.get(el));
               

            }
            Collections.sort(l);
            

            for (String el : count.keySet()) {

                if (count.get(el).equals(l.getLast())) {

                    return el;
                }
            }
            return "ø";
        } else {
            return "ø";
        }

    }

    /**
     * get The Class Gasto values end pot into an ArrayList of Doubles.
     *
     * @param values
     * @return
     */
    private ArrayList<Double> getValuesOfAList(ArrayList<Gasto> values) {
        ArrayList<Double> list = new ArrayList();
        values.forEach((n) -> {
            list.add(n.getNumeroValor());
        });
        return list;
    }

    /**
     * Calculate the the avarage costs of an especific Month.
     *
     * @param e
     * @return
     * @throws ExceptionDefault
     */
    private String totalAverageMonth(LocalDate e) throws ExceptionDefault {

        ListaGastos list = this.user.getGastos();

        ArrayList<Double> list1 = getValuesOfAList(list.retrieve(e.getMonth().toString()));
        if (!list1.isEmpty()) {
            GestaoPessoal g = new GestaoPessoal();
            return Double.toString(avg(list1, e.getMonth().maxLength()));
        } else {
            return "0.0";
        }

    }

    /**
     * Calculate the the avarage costs of an especific year.
     *
     * @param e
     * @return
     * @throws ExceptionDefault
     */
    private String totalAverageYear(LocalDate e) throws ExceptionDefault {
        ArrayList<Double> list1 = new ArrayList();
        String s = totalCostYear(e);
        list1.add(Double.parseDouble(s));
        
        NumberFormat formatter = new DecimalFormat("###.##");
        String s1 = formatter.format(avg(list1, e.lengthOfYear()));
        s1 = s1 .replace(",", ".");
        return s1;
    }

    /**
     * Calculate the the avarage of an ArrayList of doubles and a range given.
     *
     * @param l
     * @return
     */
    private Double avg(ArrayList<Double> l, double d) {
        double[] values = new double[2];
        values[0] = sumValues(l);
        values[1] = d;
        GestaoPessoal g = new GestaoPessoal();
        return (g.mediaValores(values));
    }

    /**
     * Sum values of ArrayList of doubles.
     *
     * @param dataValues
     * @return
     */
    private double sumValues(ArrayList<Double> dataValues) {
        double[] total = new double[dataValues.size()];
        for (int i = 0; i < total.length; i++) {
            total[i] = dataValues.get(i);
        }
        GestaoPessoal gestao = new GestaoPessoal();

        return gestao.valorSomado(total);

    }

    /**
     * Show the userName.
     *
     * @return
     */
    public String showName() {
        return control.user.getNome();
    }

    /**
     * Show the current Date.
     *
     * @return
     */
    public String showDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateNow = LocalDate.now();
        dateNow.format(format);
        return dateNow.toString();
    }

    /**
     * Insert costs in the User List of costs by the given data. If is not
     * possible, it shows a message.
     *
     * @param descricao
     * @param local
     * @param formaDePagamento
     * @param tipo
     * @param numeroValor
     * @param data
     * @param hora
     * @throws ExceptionDefault
     * @throws IOException
     */
    public void insertCost(String descricao, String local, String formaDePagamento, String tipo, String numeroValor, String data, String hora) throws ExceptionDefault, IOException {

        String[] dataCost = new String[7];
        dataCost[0] = descricao;
        dataCost[1] = local;
        dataCost[2] = formaDePagamento;
        dataCost[3] = tipo;
        dataCost[4] = numeroValor.replace(",", ".");
        dataCost[5] = data;
        dataCost[6] = hora;
        boolean b = this.users.retrieve(this.user.getEmail()).getGastos().create(dataCost);
        if (!b) {

            JOptionPane.showMessageDialog(MenuUsuario.menuUsuario(), "Dados incorretos");
        } else {
            control().saveData();
            JOptionPane.showMessageDialog(MenuUsuario.menuUsuario(), "Inserido com sucesso");
        }

    }

    /**
     * Delete costs in the User List of costs by the given data. If is not
     * possible, it shows a message.
     *
     * @param descricao
     * @param local
     * @param formaDePagamento
     * @param tipo
     * @param numeroValor
     * @param data
     * @param hora
     * @throws ExceptionDefault
     * @throws IOException
     */
    public void deleteCost(String descricao, String local, String formaDePagamento, String tipo, String numeroValor, String data, String hora) throws ExceptionDefault, IOException {

        String[] dataCost = new String[7];
        dataCost[0] = descricao;
        dataCost[1] = local;
        dataCost[2] = formaDePagamento;
        dataCost[3] = tipo;
        dataCost[4] = numeroValor.replace(",", ".");
        dataCost[5] = data;
        dataCost[6] = hora;
        boolean b = this.users.retrieve(this.user.getEmail()).getGastos().delete(dataCost);
        if (!b) {
            JOptionPane.showMessageDialog(MenuUsuario.menuUsuario(), "Dados incorretos");
        } else {
            control().saveData();
            JOptionPane.showMessageDialog(MenuUsuario.menuUsuario(), "Removido com sucesso");
        }

    }

    /**
     * Gives an array with the costs of the specif range of date given.
     *
     * @param e
     * @param f
     * @return
     * @throws IOException
     * @throws ExceptionDefault
     */

    public String[][] showListGastos(String e, String f) throws IOException, ExceptionDefault {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
            LocalDate d1 = LocalDate.parse(e, format);
            LocalDate d2 = LocalDate.parse(f, format);
            if (d1.isAfter(d2)) {
                JOptionPane.showMessageDialog(Menu.menu(), "Data 1 nõ pode ser posterior à data 2");
            } else {

                String[][] list1 = listTableGastos(d1, d2);
                return list1;
            }
        } catch (DateTimeParseException g) {
            JOptionPane.showMessageDialog(Menu.menu(), "Data(s) incorreta(s)");
        }
        return null;
    }

    /**
     * Return an array with the header for the MenuUsuario table.
     *
     * @return
     */
    public String[] titleGastos() {
        //String descricao, String local, String formaDePagamento, String tipo, String numeroValor, String data, String hora
        String[] n = {"Descrição", "Local", "Forma pg", "Tipo", "Valor", "Data", "Hora"};
        return n;
    }

    private String[][] listTableGastos(LocalDate e, LocalDate f) throws ExceptionDefault {
        ArrayList<String> list = new ArrayList();

        for (int i = e.getMonthValue(); i <= f.getMonthValue(); i++) {

            ArrayList<Gasto> list1 = this.user.getGastos().retrieve(Month.of(i).toString());
            for (Gasto g : list1) {
                LocalDate dT = g.getData();
                if (((dT.isAfter(e)) & (dT.isBefore(f))) | (dT.isEqual(e)) | (dT.isEqual(f))) {

                    list.add(g.getDescricao());
                    list.add(g.getLocal());
                    list.add(g.getFormaDePagamento());
                    list.add(g.getTipo());
                    list.add(Double.toString(g.getNumeroValor()));
                    list.add(g.getData().toString());
                    list.add(g.getHora().toString());

                }
            }

        }
        String[][] array1 = new String[list.size()][titleGastos().length];

        int z = 0;
        if (!list.isEmpty()) {
            for (int x = 0; x < list.size() & z < list.size(); x++) {

                for (int p = 0; p < titleGastos().length; p++) {
                    array1[x][p] = list.get(z);
                    z++;
                }
            }
        }
        return array1;

    }

    /**
     * Return an array of Gasto values in an specific date range.
     *
     * @param e
     * @param f
     * @return
     * @throws ExceptionDefault
     */
    private ArrayList<Double> listViewTable(LocalDate e, LocalDate f) throws ExceptionDefault {
        String[][] list = listTableGastos(e, f);
        ArrayList<Double> list2 = new ArrayList();
        for (String[] el : list) {
            if (el[4] != null) {
                list2.add(Double.parseDouble(el[4]));
            }
        }
        return list2;
    }

    /**
     * Return the Total of costs,cost sum and average cost into an array of
     * String.
     *
     * @param e
     * @param f
     * @return
     * @throws ExceptionDefault
     * @throws IOException
     */
    public String[] sapCosts(String e, String f) throws ExceptionDefault, IOException {
        try {
            DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");

            LocalDate d1 = LocalDate.parse(e, format);
            LocalDate d2 = LocalDate.parse(f, format);
            ArrayList<Double> list = listViewTable(d1, d2);
            NumberFormat formatter = new DecimalFormat("###.##");

            String s2 = formatter.format(sumValues(list));
            String s3 = formatter.format(avg(list, list.size()));

            s2 = s2.replace(",", ".");
            s3 = s3.replace(",", ".");
            String[] values = {
                Long.toString(list.size()),
                s2,
                s3
            };
            return values;
        } catch (DateTimeParseException g) {
            JOptionPane.showMessageDialog(Menu.menu(), "Data(s) incorreta(s)");
        }
        return null;
    }
    public void signOut() throws ExceptionDefault, IOException{
        this.user = null;
        MenuUsuario.menuUsuario().setVisible(false);
        Menu.menu().setVisible(true);
    }
}
