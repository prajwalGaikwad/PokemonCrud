package com.work.demo.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Pokemon {
   @Id
   @GeneratedValue(strategy = GenerationType.AUTO)
   private Integer pokemonId;
   private String pokemonName;
public Pokemon() {
	super();
	// TODO Auto-generated constructor stub
}
public Pokemon(Integer pokemonId, String pokemonName) {
	super();
	this.pokemonId = pokemonId;
	this.pokemonName = pokemonName;
}
public Integer getPokemonId() {
	return pokemonId;
}
public void setPokemonId(Integer pokemonId) {
	this.pokemonId = pokemonId;
}
public String getPokemonName() {
	return pokemonName;
}
public void setPokemonName(String pokemonName) {
	this.pokemonName = pokemonName;
}
@Override
public String toString() {
	return "Pokemon [pokemonId=" + pokemonId + ", pokemonName=" + pokemonName + "]";
}
}
