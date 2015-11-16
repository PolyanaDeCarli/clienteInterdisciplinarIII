/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.PessoasClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.pessoas;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class PessoasController {

    @Inject
    private PessoasClient pesc = new PessoasClient();
    private pessoas pes = new pessoas();
    List<pessoas> lsPessoa = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public PessoasController() {
    }

    public pessoas getPessoa() {
        return pes;
    }

    public void setPessoa(pessoas p) {
        this.pes = p;
    }

    public String adicionarPessoa() {
        String status = "";
        try {
            status = pesc.salvarPessoas(pes);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Pessoa não foi incluída!", ex.getMessage()));
        }
        lsPessoa = getAllPessoas();
        return "listaPessoas";
    }

    public String ExcluirPessoa(pessoas p) {
        String status = "";
        try {
            status = pesc.excluirPessoa(p);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Pessoa não foi excluída!", ex.getMessage()));
        }
        lsPessoa = getAllPessoas();
        return "listaPessoas";
    }

    public String edit(pessoas p) {
        pes = p;
        return "mntPessoas";
    }

    public String novo() {
        pes = new pessoas();
        return "mntPessoas";
    }

    public List<pessoas> getAllPessoas() {
        lsPessoa = pesc.getPessoas();
        return lsPessoa;
    }

}
