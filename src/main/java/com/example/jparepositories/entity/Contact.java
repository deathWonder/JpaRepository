package com.example.jparepositories.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;



@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Contact {
    @EmbeddedId
    private Person person;
    @Column(length = 20)
    private String phoneNumber;
    @Column(length = 20, unique = true)
    private String cityOfLiving;

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + person.getName() + '\'' +
                ", surname='" + person.getSurname() + '\'' +
                ", age=" + person.getAge() +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", cityOfLiving='" + cityOfLiving + '\'' +
                '}';
    }
}
