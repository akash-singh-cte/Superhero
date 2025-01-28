package com.example.SuperHero.repository;

import com.example.SuperHero.dto.SuperHero;
import org.springframework.data.mongodb.repository.MongoRepository;


import java.util.List;

public interface SuperheroRepository extends MongoRepository<SuperHero,String> {
    void deleteByName(String name);
    List<SuperHero> findAll();
    List<SuperHero> findAllByName(String name);
    List<SuperHero> findAllByUniverse(String name);
    List<SuperHero> findAllByuniverse(String name);
//    Optional<SuperHero> findByName(String name);
}
