package ru.netology.springbootdaohibernate.entity;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Builder
@Table(name = "PERSON")
@NoArgsConstructor
@AllArgsConstructor
public class Person {
    @EmbeddedId
    private Contact contact;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 20, nullable = false)
    private String cityOfLiving;
}