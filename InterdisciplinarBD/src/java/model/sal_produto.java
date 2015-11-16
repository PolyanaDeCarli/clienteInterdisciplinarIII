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
public class sal_produto implements Serializable {

    @Id
    @SequenceGenerator(name = "spro_sequence", sequenceName = "spro_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "spro_sequence")
    private int spro_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo")
    private produto produto;
    @Id
    @ManyToOne
    @JoinColumn(name = "sal_codigo", referencedColumnName = "sal_codigo")
    private salarios salarios;
    private int spro_horas;
    private double spro_custototal;

    public int getSpro_codigo() {
        return spro_codigo;
    }

    public void setSpro_codigo(int spro_codigo) {
        this.spro_codigo = spro_codigo;
    }

    public produto getProduto() {
        return produto;
    }

    public void setProduto(produto produto) {
        this.produto = produto;
    }

    public salarios getSalarios() {
        return salarios;
    }

    public void setSalarios(salarios salarios) {
        this.salarios = salarios;
    }

    public int getSpro_horas() {
        return spro_horas;
    }

    public void setSpro_horas(int spro_horas) {
        this.spro_horas = spro_horas;
    }

    public double getSpro_custototal() {
        return spro_custototal;
    }

    public void setSpro_custototal(double spro_custototal) {
        this.spro_custototal = spro_custototal;
    }

}
