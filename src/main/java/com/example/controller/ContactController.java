/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.example.controller;
import com.example.model.Contact;
import com.example.repository.ContactRepository;
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
 * @author qualykenvil
 */
@RestController
@CrossOrigin
public class ContactController {
    @Autowired
    private ContactRepository contactRepository;
    @GetMapping("contacts")
    public List<Contact> getAll()
    {
        return  contactRepository.findAll();
    }
    @GetMapping("contacts/{id}")
        public Contact getById(@PathVariable("id") int id) {
                return contactRepository.findOne(id);
        }

        @PostMapping("contacts")
        public String create(@RequestBody Contact contact) {
                contactRepository.save(contact);
                return "Success";
        }

        @PutMapping("contacts")
        public String update(@RequestBody Contact contact) {
                if (contactRepository.findOne(contact.getIdcontact()) == null) {
                        return "Not found";
                }
                contactRepository.save(contact);
                return "Success";
        }

        @DeleteMapping("contacts/{id}")
        public String delete(@PathVariable(value = "id") Integer id) {
                Contact contact = contactRepository.findOne(id);
                if (contact == null) {
                        return "Not found";
                }
                contactRepository.delete(contact);
                return "Success";
        }
}
