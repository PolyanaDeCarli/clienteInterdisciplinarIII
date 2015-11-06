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
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;
import javax.persistence.Temporal;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Larissa Cardoso
 */
@Entity
@XmlRootElement
public class pessoas implements Serializable {
    @Id
    @SequenceGenerator(name = "pes_sequence", sequenceName = "pes_sequence")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "pes_sequence")    
    private int pes_codigo;
    @ManyToOne
    @JoinColumn(name = "cid_codigo")
    private cidades cidades;
    private String pes_nome;
    private String pes_razaosocial;
    private String pes_cpfcnpj;
    private String pes_rg;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date pes_datanascimento;
    private char pes_sexo;
    private String pes_telefone;
    private String pes_email;
    private String pes_endereco;
    private String pes_bairro;
    private String pes_login;
    private String pes_senha;
    private boolean pes_status;

    public int getPes_codigo() {
        return pes_codigo;
    }

    public void setPes_codigo(int pes_codigo) {
        this.pes_codigo = pes_codigo;
    }

    public cidades getCidades() {
        return cidades;
    }

    public void setCidades(cidades cidades) {
        this.cidades = cidades;
    }

    public String getPes_nome() {
        return pes_nome;
    }

    public void setPes_nome(String pes_nome) {
        this.pes_nome = pes_nome;
    }

    public String getPes_razaosocial() {
        return pes_razaosocial;
    }

    public void setPes_razaosocial(String pes_razaosocial) {
        this.pes_razaosocial = pes_razaosocial;
    }

    public String getPes_cpfcnpj() {
        return pes_cpfcnpj;
    }

    public void setPes_cpfcnpj(String pes_cpfcnpj) {
        this.pes_cpfcnpj = pes_cpfcnpj;
    }

    public String getPes_rg() {
        return pes_rg;
    }

    public void setPes_rg(String pes_rg) {
        this.pes_rg = pes_rg;
    }

    public Date getPes_datanascimento() {
        return pes_datanascimento;
    }

    public void setPes_datanascimento(Date pes_datanascimento) {
        this.pes_datanascimento = pes_datanascimento;
    }

    public char getPes_sexo() {
        return pes_sexo;
    }

    public void setPes_sexo(char pes_sexo) {
        this.pes_sexo = pes_sexo;
    }

    public String getPes_telefone() {
        return pes_telefone;
    }

    public void setPes_telefone(String pes_telefone) {
        this.pes_telefone = pes_telefone;
    }

    public String getPes_email() {
        return pes_email;
    }

    public void setPes_email(String pes_email) {
        this.pes_email = pes_email;
    }

    public String getPes_endereco() {
        return pes_endereco;
    }

    public void setPes_endereco(String pes_endereco) {
        this.pes_endereco = pes_endereco;
    }

    public String getPes_bairro() {
        return pes_bairro;
    }

    public void setPes_bairro(String pes_bairro) {
        this.pes_bairro = pes_bairro;
    }

    public String getPes_login() {
        return pes_login;
    }

    public void setPes_login(String pes_login) {
        this.pes_login = pes_login;
    }

    public String getPes_senha() {
        return pes_senha;
    }

    public void setPes_senha(String pes_senha) {
        this.pes_senha = pes_senha;
    }

    public boolean isPes_status() {
        return pes_status;
    }

    public void setPes_status(boolean pes_status) {
        this.pes_status = pes_status;
    }
  
    
}
