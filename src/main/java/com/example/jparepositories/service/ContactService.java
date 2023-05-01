package com.example.jparepositories.service;

import com.example.jparepositories.entity.Contact;
import com.example.jparepositories.repository.ContactRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ContactService {

    private final ContactRepository repository;

    public ContactService(ContactRepository repository) {
        this.repository = repository;
    }

    public List<Contact> getPersonsByCity(String city) {
        city = city.toUpperCase();
        return repository.findByCityOfLiving(city);
    }

    public List<Contact> getPersonsByAge(int age) {
        return repository.findByPersonAgeLessThan(age);
    }

    public String getPersonByNameAndSurname(String name, String surname) {
        Optional<Contact> contact = repository.findByPersonNameAndPersonSurname(name, surname);

        if (contact.isPresent())
            return contact.get().toString();
        else
            return "Контакт не найден";
    }

}

