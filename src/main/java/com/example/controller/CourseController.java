/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;
import com.example.model.Course;
import com.example.model.Teacher;
import com.example.repository.CourseRepository;
import com.example.repository.TeacherRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
public class CourseController {
    @Autowired
    private CourseRepository courseRepository;
    @Autowired
    private TeacherRepository teacherRepository;
     @GetMapping("courses")
        public List<Course> getAll() {
                return courseRepository.findAll();
        }

        @GetMapping("courses/{id}")
        public Course getById(@PathVariable("id") Integer id) {
                return courseRepository.findOne(id);
        }
        
        @GetMapping("courses/findteacher/{idteacher}")
    public List<Course> getByStuId(@PathVariable("idteacher") Integer idteacher) {
        return courseRepository.findByTeacherId(idteacher);
    }

        @PostMapping("courses")
        public String create(@RequestBody Course course) {
                if (teacherRepository.findOne(course.getTeacher().getIdteacher()) == null) {
                        return "Not found";
                }
                course.setTeacher(course.getTeacher());
                courseRepository.save(course);
                return "Success";
        }
        @PutMapping("courses/{id}")
        public String update(@RequestBody Course course) {
                if (teacherRepository.findOne(course.getTeacher().getIdteacher()) == null) {
                        return "Not found";
                }
                course.setTeacher(course.getTeacher());
                courseRepository.save(course);
                return "Success";
        }

         @DeleteMapping("courses/{id}")
        public String delete(@PathVariable(value = "id") Integer id) {
                Course course = courseRepository.findOne(id);
                if (course == null) {
                        return "Not found";
                }

                courseRepository.delete(course);
                return "Success";
        }
}
