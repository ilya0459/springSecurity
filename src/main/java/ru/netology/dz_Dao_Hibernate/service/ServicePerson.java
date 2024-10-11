package ru.netology.dz_Dao_Hibernate.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import ru.netology.dz_Dao_Hibernate.entity.Person;
import ru.netology.dz_Dao_Hibernate.repository.CrudRepositoryPerson;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ServicePerson {
    private final CrudRepositoryPerson repository;

    public List<Person> findByCityOfLiving(String city) {
        return repository.findByCityOfLiving(city);
    }

    public List<Person> findPersonByDataPerson_AgeBeforeOrderByDataPersonAsc(Integer age) {
        return repository.findPersonByDataPerson_AgeBeforeOrderByDataPersonAsc
                (age);
    }

    public Optional<Person>findPersonByDataPerson_NameContainingIgnoreCaseAndAndDataPerson_SurnameContainingIgnoreCase
            (String name, String surname){
        return repository.findPersonByDataPerson_NameContainingIgnoreCaseAndAndDataPerson_SurnameContainingIgnoreCase
                (name, surname);
    }

}
