/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class custos_fixos implements Serializable {

    @Id
    @SequenceGenerator(name = "cus_sequence", sequenceName = "cus_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cus_sequence")
    private int cus_codigo;
    private String cus_descricao;
    private double cus_valor;

    public int getCus_codigo() {
        return cus_codigo;
    }

    public void setCus_codigo(int cus_codigo) {
        this.cus_codigo = cus_codigo;
    }

    public String getCus_descricao() {
        return cus_descricao;
    }

    public void setCus_descricao(String cus_descricao) {
        this.cus_descricao = cus_descricao;
    }

    public double getCus_valor() {
        return cus_valor;
    }

    public void setCus_valor(double cus_valor) {
        this.cus_valor = cus_valor;
    }
}
