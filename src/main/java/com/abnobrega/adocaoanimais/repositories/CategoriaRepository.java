package com.abnobrega.adocaoanimais.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.abnobrega.adocaoanimais.domain.Categoria;

public interface CategoriaRepository extends JpaRepository<Categoria, Integer>{

}
