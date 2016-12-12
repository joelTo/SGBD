package fr.model;

public enum StatutCommande {

	EN_COURS_DE_LIVRAISON("en cours de livraison"), FINI("fini"), EN_PREPARATION("en cours de preparation");

	private String statut;

	private StatutCommande(String statut) {
		this.statut = statut;
	}

	public String getStatutCommande() {
		return statut;
	}

}
