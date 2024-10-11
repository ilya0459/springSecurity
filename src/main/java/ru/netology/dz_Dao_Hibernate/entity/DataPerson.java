package ru.netology.dz_Dao_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Embeddable
public class DataPerson {
    @Column(length = 50, nullable = false)
    private String name;
    @Column(length = 100, nullable = false)
    private String surname;
    @Column(nullable = false)
    private int age;

}
