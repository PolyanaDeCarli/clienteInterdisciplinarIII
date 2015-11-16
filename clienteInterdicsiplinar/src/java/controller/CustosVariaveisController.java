/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.CustosVariaveisClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.custos_variaveis;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class CustosVariaveisController {

    @Inject
    private CustosVariaveisClient cvc = new CustosVariaveisClient();
    private custos_variaveis cv = new custos_variaveis();
    List<custos_variaveis> lsCustosVariaveis = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public CustosVariaveisController() {
    }

    public custos_variaveis getCustoVariavel() {
        return cv;
    }

    public void setCustoVariavel(custos_variaveis cv) {
        this.cv = cv;
    }

    public String adicionarCustoVariavel() {
        String status = "";
        try {
            status = cvc.salvarCustosVariaveis(cv);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Custo não foi incluído!", ex.getMessage()));
        }
        lsCustosVariaveis = getAllCustosVariaveis();
        return "listaCustosVariaveis";
    }

    public String ExcluirCustoVariavel(custos_variaveis c) {
        String status = "";
        try {
            status = cvc.excluirCustoVariaveis(cv);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Custo não foi excluído!", ex.getMessage()));
        }
        lsCustosVariaveis = getAllCustosVariaveis();
        return "listaCustosVariaveis";
    }

    public String edit(custos_variaveis c) {
        cv = c;
        return "mntCustosVariaveis";
    }

    public String novo() {
        cv = new custos_variaveis();
        return "mntCustosVariaveis";
    }

    public List<custos_variaveis> getAllCustosVariaveis() {
        lsCustosVariaveis = cvc.getCustosVariaveis();
        return lsCustosVariaveis;
    }

}
