package fr.model;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Livreur {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Embedded
	private NomComplet nomComplet;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public NomComplet getNomComplet() {
		return nomComplet;
	}

	public void setNomComplet(NomComplet nomComplet) {
		this.nomComplet = nomComplet;
	}

}
