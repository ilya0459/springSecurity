package ru.netology.dz_Dao_Hibernate.entity;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;
@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(schema = "migration", name = "person")
public class Person {
    @EmbeddedId
    private DataPerson dataPerson;
    @Column(name = "phone_number", nullable = false, length = 30)
    private String phoneNumber;
    @Column(name = "city_of_living",nullable = false, length = 100)
    private String cityOfLiving;


}
