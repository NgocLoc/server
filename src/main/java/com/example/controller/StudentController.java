/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RestController;
import com.example.repository.StudentRepository;
import com.example.model.Student;
import java.util.List;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

/**
 *
 * @author dell
 */
@RestController
@CrossOrigin
public class StudentController {
    @Autowired
    private StudentRepository studentRepository;
    @GetMapping("students")
    public List<Student> getAll()
    {
        return  studentRepository.findAll();
    }
    @GetMapping("students/{id}")
        public Student getById(@PathVariable("id") int id) {
                return studentRepository.findOne(id);
        }

        @PostMapping("students")
        public String create(@RequestBody Student student) {
                studentRepository.save(student);
                return "Success";
        }

        @PutMapping("students")
        public String update(@RequestBody Student student) {
                if (studentRepository.findOne(student.getIdstudent()) == null) {
                        return "Not found";
                }
                studentRepository.save(student);
                return "Success";
        }

        @DeleteMapping("students/{id}")
        public String delete(@PathVariable(value = "id") Integer id) {
                Student student = studentRepository.findOne(id);
                if (student == null) {
                        return "Not found";
                }
                studentRepository.delete(student);
                return "Success";
        }
    
    
}
