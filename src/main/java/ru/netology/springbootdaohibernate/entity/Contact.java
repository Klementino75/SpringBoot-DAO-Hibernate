package ru.netology.springbootdaohibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;

import lombok.*;

import java.io.Serializable;

@Embeddable
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
@ToString
public class Contact implements Serializable {
    @Column(name = "name", length = 50, nullable = false)
    private String name;

    @Column(name = "surname", length = 100, nullable = false)
    private String surname;

    @Column(name = "age", nullable = false)
    @Min(1)
    @Max(150)
    private int age;
}