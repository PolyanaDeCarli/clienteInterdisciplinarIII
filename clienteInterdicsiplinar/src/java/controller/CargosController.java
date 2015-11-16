/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.CargosClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import model.cargos;
import net.bootsfaces.component.Alert;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class CargosController {

    @Inject
    private CargosClient cc = new CargosClient();
    private cargos cargo = new cargos();
    List<cargos> lscargos = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public CargosController() {
    }

    public cargos getCargo() {
        return cargo;
    }

    public void setCargo(cargos car) {
        this.cargo = car;
    }

    public String adicionarCargo() {
        String status = "";
        try {
            status = cc.salvarCargo(cargo);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Cargo não foi incluído!", ex.getMessage()));
        }
        lscargos = getAllCargos();
        return "listaCargos";
    }

    public List<cargos> getAllCargos() {
        lscargos = cc.getCargos();
        return lscargos;
    }

    public String ExcluirCargo(cargos c) {
        String status = "";
        try {
            status = cc.excluirCargo(c);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Cargo não foi incluído!", ex.getMessage()));
        }
        lscargos = getAllCargos();
        return "listaCargos";
    }
    public String edit(cargos c) {
        cargo = c;
        return "mntCargos";
    }
    public String novo() {
        cargo = new cargos();
        return "mntCargos";
    }

    /*public void getCargoById(){
     cargo = cc.getCargos(book.getId());
     }*/
}
