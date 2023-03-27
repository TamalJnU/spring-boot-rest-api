package com.example.springangular.entity;

import lombok.*;

import javax.persistence.Entity;

@Entity
@Getter
@Setter
@RequiredArgsConstructor
@ToString
public class Person extends BaseEntity {

    private String name;
    private String gender;
    private Integer age;
    private String hobbies;
    private String country;

}
