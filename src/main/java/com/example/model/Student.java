/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
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

/**
 *
 * @author dell
 */
@Entity
@Table(name = "student")
@NamedQueries({
    @NamedQuery(name = "Student.findAll", query = "SELECT s FROM Student s")})
public class Student implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idstudent")
    private Integer idstudent;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "gender")
    private String gender;
    @Size(max = 45)
    @Column(name = "birth")
    private String birth;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "student")
    @JsonIgnore
    private Collection<Detail> detailCollection;

    public Student() {
    }

    public Student(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public Student(Integer idstudent, String name, String gender) {
        this.idstudent = idstudent;
        this.name = name;
        this.gender = gender;
    }

    public Integer getIdstudent() {
        return idstudent;
    }

    public void setIdstudent(Integer idstudent) {
        this.idstudent = idstudent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getBirth() {
        return birth;
    }

    public void setBirth(String birth) {
        this.birth = birth;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Collection<Detail> getDetailCollection() {
        return detailCollection;
    }

    public void setDetailCollection(Collection<Detail> detailCollection) {
        this.detailCollection = detailCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idstudent != null ? idstudent.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Student)) {
            return false;
        }
        Student other = (Student) object;
        if ((this.idstudent == null && other.idstudent != null) || (this.idstudent != null && !this.idstudent.equals(other.idstudent))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.Student[ idstudent=" + idstudent + " ]";
    }
    
}
