/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.Serializable;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@XmlRootElement
public class materiaprima_produtos implements Serializable {
    private produto produto;
    private materia_prima materia_prima;

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
