package fr.model;

public enum CategoriePizza {
	VIANDE("viande"), POISSON("posson"), SANS_VIANDE("Sans Viande");

	private String nom;

	private CategoriePizza(String nom) {
		this.nom = nom;
	}

	public String getNomCategories() {
		return nom;
	}
}
