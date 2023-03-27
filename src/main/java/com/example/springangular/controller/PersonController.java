package com.example.springangular.controller;

import com.example.springangular.entity.Person;
import com.example.springangular.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
@CrossOrigin(origins = "http://localhost:4200", allowCredentials = "true")
public class PersonController {

    @Autowired
    PersonService prService;

    @PostMapping("/person")
    public void savePerson(@RequestBody Person pr) {
        prService.save(pr);
    }

    @GetMapping("/person")
    List<Person> allPerson() {
//        List<Person> getAll = prService.getAll();
//        return getAll;
        return prService.getAll();
    }

    @DeleteMapping("/person/{id}")
    public void deletePerson(@PathVariable("id") Long id) {
        prService.delete(id);
    }

    @GetMapping("/person/{id}")
    public Person singlePerson(@PathVariable("id") Long id) {
        return prService.getOne(id);
    }

    @PutMapping("/person/{id}")
    public void editPerson(@PathVariable("id") Long id, @RequestBody Person pr) {
        prService.update(pr, id);
    }

}
