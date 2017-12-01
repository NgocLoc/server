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
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author dell
 */
@Entity
@Table(name = "detail")
@NamedQueries({
    @NamedQuery(name = "Detail.findAll", query = "SELECT d FROM Detail d")})
public class Detail implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "iddetail")
    private Integer iddetail;
    @JoinColumn(name = "idcourse", referencedColumnName = "idcourse")
    @ManyToOne(optional = false)
    private Course course;
    @JoinColumn(name = "idstudent", referencedColumnName = "idstudent")
    @ManyToOne(optional = false)
    private Student student;

    public Detail() {
    }

    public Detail(Integer iddetail) {
        this.iddetail = iddetail;
    }

    public Integer getIddetail() {
        return iddetail;
    }

    public void setIddetail(Integer iddetail) {
        this.iddetail = iddetail;
    }

    public Course getCourse() {
        return course;
    }

    public void setCourse(Course course) {
        this.course = course;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (iddetail != null ? iddetail.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Detail)) {
            return false;
        }
        Detail other = (Detail) object;
        if ((this.iddetail == null && other.iddetail != null) || (this.iddetail != null && !this.iddetail.equals(other.iddetail))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.example.model.Detail[ iddetail=" + iddetail + " ]";
    }
    
}
