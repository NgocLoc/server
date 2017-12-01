/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

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

/**
 *
 * @author dell
 */
@Entity
@Table(name = "new")
@NamedQueries({
    @NamedQuery(name = "New1.findAll", query = "SELECT n FROM New1 n")})
public class New1 implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idnew")
    private Integer idnew;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 200)
    @Column(name = "titel")
    private String titel;
    @Size(max = 45)
    @Column(name = "image")
    private String image;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 500)
    @Column(name = "description")
    private String description;

    public New1() {
    }

    public New1(Integer idnew) {
        this.idnew = idnew;
    }

    public New1(Integer idnew, String titel, String description) {
        this.idnew = idnew;
        this.titel = titel;
        this.description = description;
    }

    public Integer getIdnew() {
        return idnew;
    }

    public void setIdnew(Integer idnew) {
        this.idnew = idnew;
    }

    public String getTitel() {
        return titel;
    }

    public void setTitel(String titel) {
        this.titel = titel;
    }

    public String getImage() {
        return image;
    }

    public void setImage(String image) {
        this.image = image;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idnew != null ? idnew.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof New1)) {
            return false;
        }
        New1 other = (New1) object;
        if ((this.idnew == null && other.idnew != null) || (this.idnew != null && !this.idnew.equals(other.idnew))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.New1[ idnew=" + idnew + " ]";
    }
    
}
