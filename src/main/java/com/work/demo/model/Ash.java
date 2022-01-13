package com.work.demo.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;

@Entity
public class Ash {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
   private Integer AshId;
	private String AshName;
	
	@OneToMany(cascade = CascadeType.ALL)
	private List<Pokemon> pokemoList;

	public Ash() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Ash(Integer ashId, String ashName, List<Pokemon> pokemoList) {
		super();
		AshId = ashId;
		AshName = ashName;
		this.pokemoList = pokemoList;
	}

	public Integer getAshId() {
		return AshId;
	}

	public void setAshId(Integer ashId) {
		AshId = ashId;
	}

	public String getAshName() {
		return AshName;
	}

	public void setAshName(String ashName) {
		AshName = ashName;
	}

	public List<Pokemon> getPokemoList() {
		return pokemoList;
	}

	public void setPokemoList(List<Pokemon> pokemoList) {
		this.pokemoList = pokemoList;
	}

	@Override
	public String toString() {
		return "Ash [AshId=" + AshId + ", AshName=" + AshName + ", pokemoList=" + pokemoList + "]";
	}
	
	
	}
