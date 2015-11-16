/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@XmlRootElement
public class produto implements Serializable {

    private int pro_codigo;
    private String pro_descricao;
    List<sal_produto> lsSal;
    List<maquinas_produtos> lsMaq;
    List<materiaprima_produtos> lsMat;
    private double pro_custototal;

    public int getPro_codigo() {
        return pro_codigo;
    }

    public void setPro_codigo(int pro_codigo) {
        this.pro_codigo = pro_codigo;
    }

    public String getPro_descricao() {
        return pro_descricao;
    }

    public void setPro_descricao(String pro_descricao) {
        this.pro_descricao = pro_descricao;
    }

    public List<sal_produto> getLsSal() {
        return lsSal;
    }

    public void setLsSal(List<sal_produto> lsSal) {
        this.lsSal = lsSal;
    }

    public List<maquinas_produtos> getLsMaq() {
        return lsMaq;
    }

    public void setLsMaq(List<maquinas_produtos> lsMaq) {
        this.lsMaq = lsMaq;
    }

    public List<materiaprima_produtos> getLsMat() {
        return lsMat;
    }

    public void setLsMat(List<materiaprima_produtos> lsMat) {
        this.lsMat = lsMat;
    }

    public double getPro_custototal() {
        return pro_custototal;
    }

    public void setPro_custototal(double pro_custototal) {
        this.pro_custototal = pro_custototal;
    }

}
