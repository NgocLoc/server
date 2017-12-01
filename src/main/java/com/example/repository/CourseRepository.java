/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.repository;
import com.example.model.Course;
import java.io.Serializable;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

/**
 *
 * @author dell
 */
@Repository
public interface CourseRepository extends JpaRepository<Course, Integer>{
     @Query("SELECT r FROM Course r WHERE r.teacher.idteacher = ?1")
        List<Course> findByTeacherId(Integer id);
}
