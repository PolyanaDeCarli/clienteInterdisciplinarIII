/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.MateriaPrimaClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.materia_prima;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class MateriaPrimaController {
     @Inject
    private MateriaPrimaClient mtc = new MateriaPrimaClient();
    private materia_prima mat_prima = new materia_prima();
    List<materia_prima> lsMateriaPrima = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public MateriaPrimaController() {
    }
  public materia_prima getMateriaPrima() {
        return mat_prima;
    }

    public void setMateriaPrima(materia_prima mat) {
        this.mat_prima = mat;
    }

    public String adicionarMateriaPrima() {
        String status = "";
        try {

            status = mtc.salvarMateriaPrima(mat_prima);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Matéria prima não foi incluída!", ex.getMessage()));
        }
        lsMateriaPrima = getAllMateriaPrima();
        return "listaMateriaPrima";
    }

    public String ExcluirMateriaPrima(materia_prima m) {
        String status = "";
        try {
            status = mtc.excluirMateriaPrima(m);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Matéria Prima não foi incluída!", ex.getMessage()));
        }
        lsMateriaPrima = getAllMateriaPrima();
        return "listaMateriaPrima";
    }

    public String edit(materia_prima m) {
        mat_prima = m;
        return "mntMateriaPrima";
    }

    public String novo() {
        mat_prima = new materia_prima();
        return "mntMateriaPrima";
    }

    public List<materia_prima> getAllMateriaPrima() {
        lsMateriaPrima = mtc.getMateriaPrima();
        return lsMateriaPrima;
    }

}
