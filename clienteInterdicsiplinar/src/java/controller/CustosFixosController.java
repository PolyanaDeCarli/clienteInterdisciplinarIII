/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.CustosFixosClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.custos_fixos;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class CustosFixosController {

    @Inject
    private CustosFixosClient cfc = new CustosFixosClient();
    private custos_fixos custos = new custos_fixos();
    List<custos_fixos> lsMCustos = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public CustosFixosController() {
    }

    public custos_fixos getCustos() {
        return custos;
    }

    public void setCusto(custos_fixos cus) {
        this.custos = cus;
    }

    public String adicionarCusto() {
        String status = "";
        try {

            status = cfc.salvarCustos(custos);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Custo não foi incluído!", ex.getMessage()));
        }
        lsMCustos = getAllCustos();
        return "listaCustos";
    }

    public String ExcluirCustos(custos_fixos c) {
        String status = "";
        try {
            status = cfc.excluirCusto(c);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Custo não foi incluído!", ex.getMessage()));
        }
        lsMCustos = getAllCustos();
        return "listaCustos";
    }

    public String edit(custos_fixos c) {
        custos = c;
        return "mntCustos";
    }

    public String novo() {
        custos = new custos_fixos();
        return "mntCustos";
    }

    public List<custos_fixos> getAllCustos() {
        lsMCustos = cfc.getCusto();
        return lsMCustos;
    }
}
