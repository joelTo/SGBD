package fr.model;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class NomComplet {
	@Column(name = "NOM", length = 30, nullable = false, unique = true)
	private String nom;
	@Column(name = "PRENOM", length = 30, nullable = false)
	private String prenom;

	public NomComplet() {

	}

	public NomComplet(String nom, String prenom) {
		this.nom = nom;
		this.prenom = prenom;
	}
}
