package ru.netology.springbootdaohibernate.entity;

import jakarta.persistence.*;

import lombok.*;

@Entity
@Table(name = "PERSON")
@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class Person {
    @EmbeddedId
    private Contact contact;

    @Column(name = "phone_number", length = 20)
    private String phoneNumber;

    @Column(name = "city_of_living", length = 20, nullable = false)
    private String cityOfLiving;

    @Override
    public String toString() {
        return "{" + contact + ", '" + phoneNumber + '\'' + ", '" + cityOfLiving + '\'' + '}';
    }
}
