package com.abnobrega.adocaoanimais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abnobrega.adocaoanimais.domain.Animal;

public interface AnimalRepository extends JpaRepository<Animal, Integer>{

}
