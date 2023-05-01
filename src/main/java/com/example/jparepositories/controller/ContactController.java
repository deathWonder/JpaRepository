package com.example.jparepositories.controller;

import com.example.jparepositories.service.ContactService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ContactController {

    private final ContactService service;

    public ContactController(ContactService service) {
        this.service = service;
    }

    @GetMapping("/persons/by-city")
    private String getPersonsByCity(@RequestParam("city") String city) {
        return service.getPersonsByCity(city).toString();
    }

    @GetMapping("/persons/by-age")
    private String getPersonsByAge(@RequestParam("age") int age) {
        return service.getPersonsByAge(age).toString();
    }

    @GetMapping("/persons/by-name_surname")
    private String getPersonsByAge(@RequestParam("name")  String name, @RequestParam("surname") String surname) {
        return service.getPersonByNameAndSurname(name, surname);
    }
}
