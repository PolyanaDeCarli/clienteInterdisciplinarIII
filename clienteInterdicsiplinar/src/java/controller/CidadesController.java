/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.CidadesClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.cidades;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class CidadesController {

    @Inject
    private CidadesClient cidc = new CidadesClient();
    private cidades cid = new cidades();
    List<cidades> lsCidade = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public CidadesController() {
    }

    public cidades getCidade() {
        return cid;
    }

    public void setCidade(cidades c) {
        this.cid = c;
    }

    public List<cidades> getAllCidades() {
        lsCidade = cidc.getCidades();
        return lsCidade;
    }
}
