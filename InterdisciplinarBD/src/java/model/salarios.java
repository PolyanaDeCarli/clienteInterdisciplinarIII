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
public class salarios implements Serializable {

    @Id
    @SequenceGenerator(name = "sal_sequence", sequenceName = "sal_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "sal_sequence")
    private int sal_codigo;
    @OneToOne
    @JoinColumn(name = "car_codigo")
    private cargos cargos;
    private double sal_valor;
    @OneToOne
    @JoinColumn(name = "cuv_codigo")
    private custos_variaveis custos_variaveis;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date sal_data;

    public Date getSal_data() {
        return sal_data;
    }

    public void setSal_data(Date sal_data) {
        this.sal_data = sal_data;
    }

    public custos_variaveis getCustos_variaveis() {
        return custos_variaveis;
    }

    public void setCustos_variaveis(custos_variaveis custos_variaveis) {
        this.custos_variaveis = custos_variaveis;
    }

    public int getSal_codigo() {
        return sal_codigo;
    }

    public void setSal_codigo(int sal_codigo) {
        this.sal_codigo = sal_codigo;
    }

    public cargos getCargos() {
        return cargos;
    }

    public void setCargos(cargos cargos) {
        this.cargos = cargos;
    }

    public double getSal_valor() {
        return sal_valor;
    }

    public void setSal_valor(double sal_valor) {
        this.sal_valor = sal_valor;
    }

}
