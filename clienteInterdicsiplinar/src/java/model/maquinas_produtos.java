/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@XmlRootElement
public class maquinas_produtos implements Serializable {

    private int mqp_codigo;
    private produto produto;
    private maquinas maquinas;
    private int mqp_horas;
    private double mqp_custototal;

    public int getMqp_codigo() {
        return mqp_codigo;
    }

    public void setMqp_codigo(int mqp_codigo) {
        this.mqp_codigo = mqp_codigo;
    }

    public produto getProduto() {
        return produto;
    }

    public void setProduto(produto produto) {
        this.produto = produto;
    }

    public maquinas getMaquinas() {
        return maquinas;
    }

    public void setMaquinas(maquinas maquinas) {
        this.maquinas = maquinas;
    }

    public int getMqp_horas() {
        return mqp_horas;
    }

    public void setMqp_horas(int mqp_horas) {
        this.mqp_horas = mqp_horas;
    }

    public double getMqp_custototal() {
        return mqp_custototal;
    }

    public void setMqp_custototal(double mqp_custototal) {
        this.mqp_custototal = mqp_custototal;
    }

}
