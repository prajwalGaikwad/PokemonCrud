package com.work.demo.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.work.demo.model.Ash;
import com.work.demo.model.Pokemon;
import com.work.demo.service.AshService;
import com.work.demo.service.PokemonService;

@RestController
@RequestMapping("/pokemons")
public class PokemonController {
    
	 @Autowired
	 private PokemonService ps;
	 
	 @Autowired
	 private AshService as;
	 
	 
	 
	 @PostMapping("/create")
	 public Pokemon createPokemon(@RequestBody Pokemon pokemon) {
		 return ps.savePokemon(pokemon);
	 }
	 
	 @GetMapping("/find")
	 public Pokemon findPokemon(@RequestParam Integer pokemonId) {
		 return ps.findPokemonById(pokemonId);
	 }
	 
	 @GetMapping("/findAllPokemons")
	 public List<Pokemon> findAllPokemon(@RequestParam(value="page",defaultValue= "0") int page,
			 								@RequestParam(value="limit",defaultValue= "10") int limit) {
		 return ps.findAll(page, limit);
	 }
	 	 
	 @GetMapping("/delete")
	 public String deletePokemonById(@RequestParam Integer pokemonId) {
		 String deletePokemonRecord = ps.deletePokemomRecord(pokemonId);
		 return deletePokemonRecord;
	 }
	 
	 @PostMapping("/update")
	 public Pokemon updatePokemon(@RequestBody Pokemon pokemon) {
		 return ps.updateRecord(pokemon);
	 }
	 
	 
	 @PostMapping("/create-ash")
	 public Ash createAsh(@RequestBody Ash ash) {
		 return as.create(ash);
	 }
	
	 @GetMapping("/findashId")
	 public Ash findash(@RequestParam Integer ashId) {
		 return as.getAsh(ashId);
	 }
	 
	 @GetMapping("/findAllAsh")
	 public List<Ash> findAllAsh(@RequestParam(value="page",defaultValue= "0") int page,
			 								@RequestParam(value="limit",defaultValue= "10") int limit) {
		 return as.findAll(page, limit);
	 }
	 
	 
	 @GetMapping("/deleteashId")
	 public String deleteash(@RequestParam Integer ashId) {
		 String deleteAsh = as.delete(ashId);
		 return deleteAsh;
	 }
	 
	 @PostMapping("/updateAsh")
	 public Ash updateAsh(@RequestBody Ash ash) {
		 return as.update(ash);
	 }
	 
}

