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
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class maquinas implements Serializable {

    @Id
    @SequenceGenerator(name = "maq_sequence", sequenceName = "maq_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "maq_sequence")
    private int maq_codigo;
    private String maq_descricao;
    private double maq_valor;
    private int maq_depreciacao;
    @OneToOne
    @JoinColumn(name = "cus_codigo")
    private custos_fixos custos_fixos;

    public custos_fixos getCustos_fixos() {
        return custos_fixos;
    }

    public void setCustos_fixos(custos_fixos custos_fixos) {
        this.custos_fixos = custos_fixos;
    }

    public int getMaq_codigo() {
        return maq_codigo;
    }

    public void setMaq_codigo(int maq_codigo) {
        this.maq_codigo = maq_codigo;
    }

    public String getMaq_descricao() {
        return maq_descricao;
    }

    public void setMaq_descricao(String maq_descricao) {
        this.maq_descricao = maq_descricao;
    }

    public double getMaq_valor() {
        return maq_valor;
    }

    public void setMaq_valor(double maq_valor) {
        this.maq_valor = maq_valor;
    }

    public int getMaq_depreciacao() {
        return maq_depreciacao;
    }

    public void setMaq_depreciacao(int maq_depreciacao) {
        this.maq_depreciacao = maq_depreciacao;
    }

}
