/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;
import com.example.model.Teacher;
import com.example.repository.TeacherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.repository.query.Param;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author dell
 */
@RestController
@CrossOrigin
public class TeacherController {
    @Autowired
    private TeacherRepository teacherRepository;
    @GetMapping("teachers")
    public List<Teacher> getAll()
    {
        return  teacherRepository.findAll();
    }
    @GetMapping("teachers/{id}")
        public Teacher getById(@PathVariable("id") int id) {
                return teacherRepository.findOne(id);
        }
        
         @GetMapping("teachers/findname")
    public List<Teacher> getByName(@Param("name") String name) {
        return teacherRepository.findBynameContaining(name);
    }

        @PostMapping("teachers")
        public String create(@RequestBody Teacher teacher) {
                teacherRepository.save(teacher);
                return "Success";
        }

        @PutMapping("teachers")
        public String update(@RequestBody Teacher teacher) {
                if (teacherRepository.findOne(teacher.getIdteacher()) == null) {
                        return "Not found";
                }
                teacherRepository.save(teacher);
                return "Success";
        }

        @DeleteMapping("teachers/{id}")
        public String delete(@PathVariable(value = "id") Integer id) {
                Teacher teacher = teacherRepository.findOne(id);
                if (teacher == null) {
                        return "Not found";
                }
                teacherRepository.delete(teacher);
                return "Success";
        }
    
}
