/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class cidades implements Serializable {

    @Id
    private int cid_codigo;
    private String cid_nome;
    private char cid_uf;

    public int getCid_codigo() {
        return cid_codigo;
    }

    public void setCid_codigo(int cid_codigo) {
        this.cid_codigo = cid_codigo;
    }

    public String getCid_nome() {
        return cid_nome;
    }

    public void setCid_nome(String cid_nome) {
        this.cid_nome = cid_nome;
    }

    public char getCid_uf() {
        return cid_uf;
    }

    public void setCid_uf(char cid_uf) {
        this.cid_uf = cid_uf;
    }

}
