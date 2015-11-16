/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import acesso.ProdutosClient;
import java.util.ArrayList;
import java.util.List;
import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import model.materia_prima;
import model.materiaprima_produtos;
import model.produto;

/**
 *
 * @author Larissa Cardoso
 */
@ManagedBean
@SessionScoped
public class ProdutosController {

    @Inject
    private ProdutosClient pc = new ProdutosClient();
    private produto pro = new produto();
    List<produto> lsProduto = new ArrayList<>();
    FacesContext facesContext = FacesContext.getCurrentInstance();

    public ProdutosController() {
    }

    public produto getProduto() {
        return pro;
    }

    public void setProduto(produto p) {
        this.pro = p;
    }

    public String adicionarProduto() {
        String status = "";
        try {
            status = pc.salvarProdutos(pro);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Produto não foi incluído!", ex.getMessage()));
        }
        lsProduto = getAllProdutos();
        return "listaProdutos";
    }

    public String ExcluirProduto(produto p) {
        String status = "";
        try {
            status = pc.excluirProduto(p);

        } catch (Exception ex) {
            facesContext
                    .addMessage(status, new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Produto não foi excluído!", ex.getMessage()));
        }
        lsProduto = getAllProdutos();
        return "listaProdutos";
    }

    public String edit(produto p) {
        pro = p;
        return "mntProdutos";
    }

    public String novo() {
        pro = new produto();
        return "mntProdutos";
    }

    public List<produto> getAllProdutos() {
        lsProduto = pc.getProdutos();
        return lsProduto;
    }

    public List<materiaprima_produtos> adicionarMateriaPrima(int pro_cod, int mat_cod) {
        try {
            materiaprima_produtos mp = new materiaprima_produtos();
            materia_prima m = new materia_prima();
            m.setMat_codigo(mat_cod);
            pro.setPro_codigo(pro_cod);
            mp.setMateria_prima(m);
            mp.setProduto(pro);
            pro.getLsMat().add(mp);

        } catch (Exception ex) {
            facesContext
                    .addMessage("", new FacesMessage(
                                    FacesMessage.SEVERITY_ERROR,
                                    "Registro não foi incluído!", ex.getMessage()));
        }

        return pro.getLsMat();
    }
}
