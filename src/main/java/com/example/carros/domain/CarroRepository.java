package com.example.carros.domain;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Aula 25: JPA - Lista de Carros de banco de dados
 */
//public interface CarroRepository extends CrudRepository<Carro, Long> {

/**
 * Aula 38: DTO - Data Transfer Object JPARepository
 */
public interface CarroRepository extends JpaRepository<Carro, Long> {

    /**
     * Aula 28: Get Carro by Tipo
     */
//    Iterable<Carro> findByTipo(String tipo);

    /**
     * Aula 35: GET - 204 No Content (CrudRepository)
     */
    List<Carro> findByTipo(String tipo);
}
