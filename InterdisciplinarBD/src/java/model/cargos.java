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
import javax.persistence.NamedQuery;
import javax.persistence.SequenceGenerator;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class cargos implements Serializable {

    @Id
    @SequenceGenerator(name = "car_sequence", sequenceName = "car_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "car_sequence") 
    private int car_codigo;
    private String car_descricao;

    public int getCar_codigo() {
        return car_codigo;
    }

    public void setCar_codigo(int car_codigo) {
        this.car_codigo = car_codigo;
    }

    public String getCar_descricao() {
        return car_descricao;
    }

    public void setCar_descricao(String car_descricao) {
        this.car_descricao = car_descricao;
    }

}
