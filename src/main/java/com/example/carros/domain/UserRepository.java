package com.example.carros.domain;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Aula 64: Database Authentication parte 1
 */
public interface UserRepository extends JpaRepository<User, Long> {

    User findByLogin(String login);
}
