package com.example.jparepositories.repository;

import com.example.jparepositories.entity.Contact;
import com.example.jparepositories.entity.Person;
import org.springframework.data.domain.Sort;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Person> {

    List<Contact> findByCityOfLiving(String cityOfLiving);

    List<Contact> findByPersonAgeLessThan(long age, Sort sort);

    Optional<Contact> findByPersonNameAndPersonSurname(String person_name, String person_surname);
}
