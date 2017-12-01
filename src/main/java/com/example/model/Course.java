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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "course")
@NamedQueries({
    @NamedQuery(name = "Course.findAll", query = "SELECT c FROM Course c")})
public class Course implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "idcourse")
    private Integer idcourse;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 45)
    @Column(name = "name")
    private String name;
    @Column(name = "price")
    private Integer price;
    @Size(max = 500)
    @Column(name = "description")
    private String description;
    @JoinColumn(name = "idteacher", referencedColumnName = "idteacher")
    @ManyToOne(optional = false)
    private Teacher teacher;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "course")
    @JsonIgnore
    private Collection<Detail> detailCollection;

    public Course() {
    }

    public Course(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public Course(Integer idcourse, String name) {
        this.idcourse = idcourse;
        this.name = name;
    }

    public Integer getIdcourse() {
        return idcourse;
    }

    public void setIdcourse(Integer idcourse) {
        this.idcourse = idcourse;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Teacher getTeacher() {
        return teacher;
    }

    public void setTeacher(Teacher teacher) {
        this.teacher = teacher;
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
        hash += (idcourse != null ? idcourse.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Course)) {
            return false;
        }
        Course other = (Course) object;
        if ((this.idcourse == null && other.idcourse != null) || (this.idcourse != null && !this.idcourse.equals(other.idcourse))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.Course[ idcourse=" + idcourse + " ]";
    }
    
}
