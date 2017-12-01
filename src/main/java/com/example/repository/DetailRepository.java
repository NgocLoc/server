/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;
import com.example.model.Detail;
import java.io.Serializable;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author dell
 */
import org.springframework.stereotype.Repository;
@Repository
public interface DetailRepository extends JpaRepository<Detail, Integer>{
    
}
