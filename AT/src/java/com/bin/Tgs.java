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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "tgs")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Tgs.findAll", query = "SELECT t FROM Tgs t")
    , @NamedQuery(name = "Tgs.findById", query = "SELECT t FROM Tgs t WHERE t.id = :id")
    , @NamedQuery(name = "Tgs.findByName", query = "SELECT t FROM Tgs t WHERE t.name = :name")})
public class Tgs implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @JoinColumn(name = "id_fk", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private Places idFk;

    public Tgs() {
    }

    public Tgs(Integer id) {
        this.id = id;
    }

    public Tgs(Integer id, String name) {
        this.id = id;
        this.name = name;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Places getIdFk() {
        return idFk;
    }

    public void setIdFk(Places idFk) {
        this.idFk = idFk;
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
        if (!(object instanceof Tgs)) {
            return false;
        }
        Tgs other = (Tgs) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bin.Tgs[ id=" + id + " ]";
    }
    
}
