/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;
import com.example.repository.New1Repository;
import com.example.model.New1;
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
public class New1Controller {
    @Autowired
    private New1Repository new1Repository;
    @GetMapping("new1s")
        public List<New1> getAll() {
                return new1Repository.findAll();
        }

        @GetMapping("new1s/{id}")
        public New1 getById(@PathVariable("id") Integer id) {
                return new1Repository.findOne(id);
        }
        
          @PostMapping("new1s")
        public String create(@RequestBody New1 new1) {
                new1Repository.save(new1);
                return "Success";
        }

        @PutMapping("new1s")
        public String update(@RequestBody New1 new1) {
                if (new1Repository.findOne(new1.getIdnew()) == null) {
                        return "Not found";
                }
                new1Repository.save(new1);
                return "Success";
        }

        @DeleteMapping("new1s/{id}")
        public String delete(@PathVariable(value = "id") Integer id) {
                New1 new1 = new1Repository.findOne(id);
                if (new1 == null) {
                        return "Not found";
                }
                new1Repository.delete(new1);
                return "Success";
        }

}
