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
public class maquinas implements Serializable {

    private int maq_codigo;
    private String maq_descricao;
    private double maq_valor;
    private int maq_depreciacao;

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
