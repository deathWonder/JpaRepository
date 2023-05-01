package com.example.jparepositories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;
import java.util.Objects;

@Embeddable
public class Person implements Serializable {

    @Column(nullable = false, length = 20)
    private String name;
    @Column(nullable = false, length = 20)
    private String surname;
    @Column(nullable = false, precision = 2)
    private long age;

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public long getAge() {
        return age;
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Person person = (Person) o;
        return age == person.age && Objects.equals(name, person.name) && Objects.equals(surname, person.surname);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, surname, age);
    }

    @Override
    public String toString() {
        return "Person{" +
                "name='" + name + '\'' +
                ", surname='" + surname + '\'' +
                ", age=" + age +
                '}';
    }
}
