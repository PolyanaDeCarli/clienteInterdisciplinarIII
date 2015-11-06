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
public class materia_prima implements Serializable {
    @Id
    @SequenceGenerator(name = "mat_sequence", sequenceName = "mat_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "mat_sequence")
    private int mat_codigo;
    private String mat_descricao;
    private double mat_preco;

    public int getMat_codigo() {
        return mat_codigo;
    }

    public void setMat_codigo(int mat_codigo) {
        this.mat_codigo = mat_codigo;
    }

    public String getMat_descricao() {
        return mat_descricao;
    }

    public void setMat_descricao(String mat_descricao) {
        this.mat_descricao = mat_descricao;
    }

    public double getMat_preco() {
        return mat_preco;
    }

    public void setMat_preco(double mat_preco) {
        this.mat_preco = mat_preco;
    }

}
