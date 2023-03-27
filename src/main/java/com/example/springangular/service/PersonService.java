package com.example.springangular.service;

import com.example.springangular.entity.Person;
import com.example.springangular.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    PersonRepository prRepo;

    public void save(Person pr) {
        if(pr.getId() != null) {
            prRepo.findById(pr.getId()).map(old -> {
                old.setName(pr.getName());
                old.setGender(pr.getGender());
                old.setAge(pr.getAge());
                old.setHobbies(pr.getHobbies());
                old.setCountry(pr.getCountry());
                return prRepo.save(pr);
            })
                .orElseGet(() -> {
                     return prRepo.save(pr);
                });
        } else {
            prRepo.save(pr);
        }
    }

    public void update(Person pr, Long id) {
        prRepo.findById(pr.getId()).map(old -> {
            old.setName(pr.getName());
            old.setGender(pr.getGender());
            old.setAge(pr.getAge());
            old.setHobbies(pr.getHobbies());
            old.setCountry(pr.getCountry());
            return prRepo.save(old);
        })
                .orElseGet(() -> {
                    return prRepo.save(pr);
                });
    }

    public List<Person> getAll () {
        return prRepo.findAll();
    }

    public Person getOne (Long id) {
        return prRepo.findById(id).orElse(new Person());
    }

    public void delete(Long id) {
        Person pr = new Person();
        pr.setId(id);
        prRepo.delete(pr);
    }

    //hello

}
