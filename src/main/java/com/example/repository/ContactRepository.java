/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;
import com.example.model.Contact;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author qualykenvil
 */
@Repository
public interface ContactRepository extends JpaRepository<Contact, Integer>{
    
}
