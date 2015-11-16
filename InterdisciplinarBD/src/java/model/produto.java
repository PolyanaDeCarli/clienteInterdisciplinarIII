/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class produto implements Serializable {

    @Id
    @SequenceGenerator(name = "pro_sequence", sequenceName = "pro_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pro_sequence")
    private int pro_codigo;
    private String pro_descricao;
    @OneToMany
    List<sal_produto> lsSal;
    @OneToMany
    List<maquinas_produtos> lsMaq;
    @OneToMany
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
