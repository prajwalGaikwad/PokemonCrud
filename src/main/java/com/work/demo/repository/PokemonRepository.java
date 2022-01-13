package com.work.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.work.demo.model.Pokemon;

@Repository
public interface PokemonRepository extends JpaRepository<Pokemon, Integer> {

	
}
