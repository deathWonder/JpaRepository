package com.example.jparepositories.repository;

import com.example.jparepositories.entity.Contact;
import com.example.jparepositories.entity.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Person> {

    @Query("select c from Contact c where c.cityOfLiving = :cityOfLiving")
    List<Contact> findByCityOfLiving(String cityOfLiving);

    @Query("select c from Contact c where c.person.age > :age order by c.person.age")
    List<Contact> findByPersonAgeLessThan(long age);

    @Query("select c from Contact c where c.person.name = :person_name and c.person.surname = :person_surname")
    Optional<Contact> findByPersonNameAndPersonSurname(String person_name, String person_surname);
}
