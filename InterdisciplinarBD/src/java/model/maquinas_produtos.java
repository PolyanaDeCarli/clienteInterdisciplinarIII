/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class maquinas_produtos implements Serializable {

    @Id
    @SequenceGenerator(name = "mqp_sequence", sequenceName = "mqp_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mqp_sequence")
    private int mqp_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo")
    private produto produto;
    @Id
    @ManyToOne
    @JoinColumn(name = "maq_codigo", referencedColumnName = "maq_codigo")
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
