package com.cabinet.modele.entities;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Creneau {

	@Id
	@GeneratedValue(strategy = GenerationType.TABLE, generator = "rdv_gen")
	private Integer id;
	
	
	public Integer getId() {
		return id;
	}
	
}
