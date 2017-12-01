/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;
import com.example.model.Detail;
import com.example.model.Course;
import com.example.model.Student;
import com.example.repository.DetailRepository;
import com.example.repository.CourseRepository;
import com.example.repository.StudentRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */
@RestController
@CrossOrigin
public class DetailController {
    
    @Autowired
    private DetailRepository detailRepository;
    @Autowired
    private StudentRepository studentRepository;
    @Autowired
    private CourseRepository courseRepository;
    
     @GetMapping("details")
        public List<Detail> getAll() {
                return detailRepository.findAll();
        }

        @GetMapping("details/{id}")
        public Detail getById(@PathVariable("id") Integer id) {
                return detailRepository.findOne(id);
        }
}
