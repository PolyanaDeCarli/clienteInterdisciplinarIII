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
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class custos_variaveis implements Serializable {

    @Id
    @SequenceGenerator(name = "cuv_sequence", sequenceName = "cuv_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "cuv_sequence")
    private int cuv_codigo;
    private String cuv_descricao;
    private double cuv_valor;

    public int getCuv_codigo() {
        return cuv_codigo;
    }

    public void setCuv_codigo(int cuv_codigo) {
        this.cuv_codigo = cuv_codigo;
    }

    public String getCuv_descricao() {
        return cuv_descricao;
    }

    public void setCuv_descricao(String cuv_descricao) {
        this.cuv_descricao = cuv_descricao;
    }

    public double getCuv_valor() {
        return cuv_valor;
    }

    public void setCuv_valor(double cuv_valor) {
        this.cuv_valor = cuv_valor;
    }

}
