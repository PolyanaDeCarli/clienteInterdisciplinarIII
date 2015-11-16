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
public class materiaprima_produtos implements Serializable {

    @Id
    @SequenceGenerator(name = "mp_sequence", sequenceName = "mp_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mp_sequence")
    private int mp_codigo;
    @Id
    @ManyToOne
    @JoinColumn(name = "pro_codigo", referencedColumnName = "pro_codigo")
    private produto produto;
    @Id
    @ManyToOne
    @JoinColumn(name = "mat_codigo", referencedColumnName = "mat_codigo")
    private materia_prima materia_prima;
    private double mp_quantidade;
    private double mp_custototal;

    public int getMp_codigo() {
        return mp_codigo;
    }

    public void setMp_codigo(int mp_codigo) {
        this.mp_codigo = mp_codigo;
    }

    public double getMp_quantidade() {
        return mp_quantidade;
    }

    public void setMp_quantidade(double mp_quantidade) {
        this.mp_quantidade = mp_quantidade;
    }

    public double getMp_custototal() {
        return mp_custototal;
    }

    public void setMp_custototal(double mp_custototal) {
        this.mp_custototal = mp_custototal;
    }

    public produto getProduto() {
        return produto;
    }

    public void setProduto(produto produto) {
        this.produto = produto;
    }

    public materia_prima getMateria_prima() {
        return materia_prima;
    }

    public void setMateria_prima(materia_prima materia_prima) {
        this.materia_prima = materia_prima;
    }

}
