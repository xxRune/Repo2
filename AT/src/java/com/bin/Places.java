/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.bin;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author PRECISION
 */
@Entity
@Table(name = "places")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Places.findAll", query = "SELECT p FROM Places p")
    , @NamedQuery(name = "Places.findById", query = "SELECT p FROM Places p WHERE p.id = :id")
    , @NamedQuery(name = "Places.findByCategory", query = "SELECT p FROM Places p WHERE p.category = :category")
    , @NamedQuery(name = "Places.findByName", query = "SELECT p FROM Places p WHERE p.name = :name")
    , @NamedQuery(name = "Places.findByPosURL", query = "SELECT p FROM Places p WHERE p.posURL = :posURL")
    , @NamedQuery(name = "Places.findByPlcFk", query = "SELECT p FROM Places p WHERE p.plcFk = :plcFk")})
public class Places implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "category")
    private String category;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 20)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "posURL")
    private String posURL;
    @Basic(optional = false)
    @NotNull
    @Column(name = "plc_fk")
    private int plcFk;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "idFk")
    private Collection<Tgs> tgsCollection;

    public Places() {
    }

    public Places(Integer id) {
        this.id = id;
    }

    public Places(Integer id, String category, String name, String posURL, int plcFk) {
        this.id = id;
        this.category = category;
        this.name = name;
        this.posURL = posURL;
        this.plcFk = plcFk;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPosURL() {
        return posURL;
    }

    public void setPosURL(String posURL) {
        this.posURL = posURL;
    }

    public int getPlcFk() {
        return plcFk;
    }

    public void setPlcFk(int plcFk) {
        this.plcFk = plcFk;
    }

    @XmlTransient
    public Collection<Tgs> getTgsCollection() {
        return tgsCollection;
    }

    public void setTgsCollection(Collection<Tgs> tgsCollection) {
        this.tgsCollection = tgsCollection;
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
        if (!(object instanceof Places)) {
            return false;
        }
        Places other = (Places) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.bin.Places[ id=" + id + " ]";
    }
    
}
