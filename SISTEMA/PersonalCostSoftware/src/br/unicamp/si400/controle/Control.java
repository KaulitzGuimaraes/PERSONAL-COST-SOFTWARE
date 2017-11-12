/*
 * Faculdade de Tecnologia da UNICAMP 
 * SI400 - Programação Orientada a Objetos II (JAVA)
 *  author - Kaulitz Guimaraes RA: 188530
 */
package br.unicamp.si400.controle;

import br.unicamp.si400.arquivo.Arquivo;
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
import java.time.LocalDate;
import java.time.Month;
import java.time.format.DateTimeFormatter;
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

    private Arquivo data;
    private UsuariosDoSistema users;
    private Usuario user;

    private static Control control;

    private Control() {
        this.data = new Arquivo();
        this.users = new UsuariosDoSistema();

    }

    /**
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
     *
     */
    public void loadData() {

        this.users = new UsuariosDoSistema();
        this.users = (UsuariosDoSistema) this.data.load(this.users);

    }

    /**
     *
     */
    public void saveData() {
        data.save(this.users);
    }

    /**
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
                MenuUsuario.menuUsuario().setVisible(true);

            }

        } catch (NullPointerException e) {
            JOptionPane.showMessageDialog(Menu.menu(), "Usuario inexistente ou incorreto");
        }

    }

    /**
     *
     * @param email
     * @param name
     * @param question
     * @param answer
     * @param password
     * @param cpassword
     * @throws ExceptionDefault
     */
    public void newUser(String email, String name, String question, String answer, char[] password, char[] cpassword) throws ExceptionDefault {

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
     * @param email
     * @throws ExceptionDefault
     */
    public void forgotPassword(String email) throws ExceptionDefault {

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
     *
     * @param email
     * @return
     * @throws br.unicamp.si400.excecao.ExceptionDefault
     */
    public boolean checkUser(String email) throws ExceptionDefault {
        Usuario buffer = control().users.retrieve(email);
        return buffer != null;
    }

    /**
     *
     * @param password
     * @param confirmpassword
     * @throws ExceptionDefault
     */
    public void changePassword(char[] password, char[] confirmpassword) throws ExceptionDefault {
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
     *
     * @return @throws ExceptionDefault
     * @throws IOException
     */
    public List<String> setInfoHome() throws ExceptionDefault, IOException {
        List<String> listInfo = new ArrayList();
        listInfo.add(totalCostMonth(LocalDate.now()));
        listInfo.add(totalCostYear(LocalDate.now()));
        listInfo.add(totalAverageMonth(LocalDate.now()));
        listInfo.add(totalAverageYear(LocalDate.now()));
        listInfo.add(mostSCost(LocalDate.now(), loadListType()));
        return listInfo;

    }

    /**
     *
     * @return @throws IOException
     */
    public List<String> loadListType() throws IOException {

        return loadList("TypeList.txt");
    }

    /**
     *
     * @return @throws java.io.IOException
     */
    public List<String> loadListPayment() throws IOException {

        return loadList("PaymentList.txt");
    }

    private List<String> loadList(String fileName) throws IOException {
        File file = new File(fileName);

        List<String> words = Files.readAllLines(file.toPath());

        return words;

    }

    /**
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

    private String totalCostYear(LocalDate e) throws ExceptionDefault {
        ArrayList<Double> list3 = new ArrayList();
        for (Month n : Month.values()) {

            list3.add(Double.parseDouble(totalCostMonth(e.withMonth(n.getValue()))));
        }

        return Double.toString(sumValues(list3));

    }

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
                if (count.get(el).equals(l.getFirst())) {
                    return el;
                }
            }
            return "ø";
        } else {
            return "ø";
        }

    }

    private ArrayList<Double> getValuesOfAList(ArrayList<Gasto> values) {
        ArrayList<Double> list = new ArrayList();
        values.forEach((n) -> {
            list.add(n.getNumeroValor());
        });
        return list;
    }

    private String totalAverageMonth(LocalDate e) throws ExceptionDefault {

        ListaGastos list = this.user.getGastos();
        ArrayList<Double> list1 = getValuesOfAList(list.retrieve(e.getMonth().toString()));
        if (!list1.isEmpty()) {
            GestaoPessoal g = new GestaoPessoal();
            return Double.toString(avg(list1));
        } else {
            return "0.0";
        }

    }

    private String totalAverageYear(LocalDate e) throws ExceptionDefault {
        ArrayList<Double> list1 = new ArrayList();

        for (Month n : Month.values()) {

            list1.add(Double.parseDouble(totalAverageMonth(e.withMonth(n.getValue()))));
        }

        return Double.toString(avg(list1));
    }

    private Double avg(ArrayList<Double> l) {
        double[] values = new double[2];
        values[0] = sumValues(l);
        values[1] = l.size();
        GestaoPessoal g = new GestaoPessoal();
        return (g.mediaValores(values));
    }

    private double sumValues(ArrayList<Double> dataValues) {
        double[] total = new double[dataValues.size()];
        for (int i = 0; i < total.length; i++) {
            total[i] = dataValues.get(i);
        }
        GestaoPessoal gestao = new GestaoPessoal();

        return gestao.valorSomado(total);

    }

    /**
     *
     * @return
     */
    public String showName() {
        return control.user.getNome();
    }

    /**
     *
     * @return
     */
    public String showDate() {
        DateTimeFormatter format = DateTimeFormatter.ofPattern("dd/MM/yyyy");
        LocalDate dateNow = LocalDate.now();
        dateNow.format(format);
        return dateNow.toString();
    }
}
