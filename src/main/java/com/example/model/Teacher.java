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
@Table(name = "teacher")
@NamedQueries({
    @NamedQuery(name = "Teacher.findAll", query = "SELECT t FROM Teacher t")})
public class Teacher implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idteacher")
    private Integer idteacher;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "age")
    private Integer age;
    @Size(max = 45)
    @Column(name = "address")
    private String address;
    @Size(max = 45)
    @Column(name = "contact")
    private String contact;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "teacher")
    @JsonIgnore
    private Collection<Course> courseCollection;

    public Teacher() {
    }

    public Teacher(Integer idteacher) {
        this.idteacher = idteacher;
    }

    public Teacher(Integer idteacher, String name) {
        this.idteacher = idteacher;
        this.name = name;
    }

    public Integer getIdteacher() {
        return idteacher;
    }

    public void setIdteacher(Integer idteacher) {
        this.idteacher = idteacher;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getContact() {
        return contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public Collection<Course> getCourseCollection() {
        return courseCollection;
    }

    public void setCourseCollection(Collection<Course> courseCollection) {
        this.courseCollection = courseCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idteacher != null ? idteacher.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Teacher)) {
            return false;
        }
        Teacher other = (Teacher) object;
        if ((this.idteacher == null && other.idteacher != null) || (this.idteacher != null && !this.idteacher.equals(other.idteacher))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.Teacher[ idteacher=" + idteacher + " ]";
    }
    
}
