package com.work.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.work.demo.model.Pokemon;
import com.work.demo.repository.PokemonRepository;

@Service
public class PokemonService {

	@Autowired
	private PokemonRepository pr;

	public Pokemon savePokemon(Pokemon p) {
		Pokemon pokemon = pr.save(p);
		return pokemon;
	}

	public Pokemon  findPokemonById(Integer pokemonId) {
		Optional<Pokemon> findById = pr.findById(pokemonId);

		if (findById.isPresent()) {
			return findById.get() ;
		}
		return null;

	}
	
	public List<Pokemon> findAll(int page, int limit) {
		if(page > 0) page = page-1;
		
		Pageable pageableRequest= PageRequest.of(page, limit);
		
		Page<Pokemon> pokemonPage = pr.findAll(pageableRequest);
		
		List<Pokemon> pokemons = pokemonPage.getContent();
		
		if(pokemons!=null && !pokemons.isEmpty()) {
		  return pokemons;
		}
		return pokemons;

	}

	public String deletePokemomRecord(Integer pokemonId) {
		try {
			pr.deleteById(pokemonId);
		} catch (Exception e) {
			return "pokemon is not exist for id :" + pokemonId;
		}

		return "pokemon is deleted for :" + pokemonId;
	}

	public Pokemon updateRecord(Pokemon pokemon) {
		Pokemon returnObj = new Pokemon();
		Optional<Pokemon> findById = pr.findById(pokemon.getPokemonId());
		if (findById.isPresent()) {
			returnObj=pr.save(pokemon);
			return returnObj;
		} else {
			return returnObj;
		}

	}

}
