/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author PRECISION
 */
@Entity
@Table(name = "descri")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Descri.findAll", query = "SELECT d FROM Descri d")
    , @NamedQuery(name = "Descri.findById", query = "SELECT d FROM Descri d WHERE d.id = :id")
    , @NamedQuery(name = "Descri.findByDe", query = "SELECT d FROM Descri d WHERE d.de = :de")})
public class Descri implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 1500)
    @Column(name = "de")
    private String de;

    public Descri() {
    }

    public Descri(Integer id) {
        this.id = id;
    }

    public Descri(Integer id, String de) {
        this.id = id;
        this.de = de;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDe() {
        return de;
    }

    public void setDe(String de) {
        this.de = de;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Descri)) {
            return false;
        }
        Descri other = (Descri) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bin.Descri[ id=" + id + " ]";
    }
    
}
