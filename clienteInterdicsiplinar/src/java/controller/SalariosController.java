/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.CustosVariaveisClient;
import acesso.SalariosClient;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.custos_variaveis;
import model.salarios;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class SalariosController {

    @Inject
    private SalariosClient sc = new SalariosClient();
    private salarios sal = new salarios();
    List<salarios> lsSalarios = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    private CustosVariaveisClient cusv = new CustosVariaveisClient();
    private custos_variaveis cuv = new custos_variaveis();

    public SalariosController() {
    }

    public salarios getSalario() {
        return sal;
    }

    public void setSalario(salarios s) {
        this.sal = s;
    }

    public String adicionarSalario() {
        String status = "";
        try {
            status = sc.salvarSalarios(sal);
        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Salário não foi incluído!", ex.getMessage()));
        }
        lsSalarios = getAllSalarios();
        return "listaSalarios";
    }

    public String ExcluirSalario(salarios s) {
        String status = "";
        try {
            status = sc.excluirSalario(s);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Salário não foi excluído!", ex.getMessage()));
        }
        lsSalarios = getAllSalarios();
        return "listaSalarios";
    }

    public String edit(salarios s) {
        sal = s;
        return "mntSalarios";
    }

    public String novo() {
        sal = new salarios();
        return "mntSalarios";
    }

    public List<salarios> getAllSalarios() {
        lsSalarios = sc.getSalarios();
        return lsSalarios;
    }

}
