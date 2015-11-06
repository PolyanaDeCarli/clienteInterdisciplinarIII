/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.CargosClient;
import acesso.MaquinasClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.maquinas;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class MaquinasController {

    @Inject
    private MaquinasClient mc = new MaquinasClient();
    private maquinas maquina = new maquinas();
    List<maquinas> maquinas = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public MaquinasController() {
    }

    public maquinas getMaquina() {
        return maquina;
    }

    public void setMaquina(maquinas maq) {
        this.maquina = maq;
    }

    public String adicionarMaquina() {
        String status = "";
        try {

            status = mc.adicionarMaquina(maquina);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Máquina não foi incluída!", ex.getMessage()));
        }
        maquinas = getAllMaquinas();
        return "listaMaquinas";
    }

    public List<maquinas> getAllMaquinas() {
        maquinas = mc.getMaquinas();
        return maquinas;
    }

}
