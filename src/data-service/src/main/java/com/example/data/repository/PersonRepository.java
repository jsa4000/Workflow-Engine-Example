package com.example.data.repository;

import com.example.data.entity.Person;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import java.util.List;
import java.util.UUID;

@RepositoryRestResource(collectionResourceRel = "people", path = "people")
interface PersonRepository extends
    PagingAndSortingRepository<Person, UUID>,
    CrudRepository<Person, UUID> {

    List<Person> findByLastName(@Param("name") String name);
}
