package fr.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

import org.apache.commons.lang3.builder.EqualsBuilder;

@Entity
@NamedQuery(name = "code.findByCode", query = "SELECT p FROM Pizza p WHERE p.code=:name")

@Table(name = "pizza")
public class Pizza {
	@Id
	private int id;
	@Column(name = "reference", length = 30, nullable = false, unique = true)
	private String code;
	@Column(name = "libelle", length = 30, nullable = false)
	private String nom;
	@Column(name = "prix", length = 30, nullable = false)
	private Double prix;
	@Enumerated(EnumType.STRING)
	private CategoriePizza catPizza;

	public CategoriePizza getCatPizza() {
		return catPizza;
	}

	public void setCatPizza(CategoriePizza catPizza) {
		this.catPizza = catPizza;
	}

	private static int nbPizzas;

	public Pizza(String code, String nom, CategoriePizza catPizza, double prix) {
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.catPizza = catPizza;
	}

	public Pizza(int id, String code, String nom, CategoriePizza catPizza, double prix) {
		super();
		this.id = id;
		this.code = code;
		this.nom = nom;
		this.prix = prix;
		this.catPizza = catPizza;
		nbPizzas++;
	}

	public boolean equals(Pizza obj) {
		if (obj == null) {
			return false;
		}
		if (obj == this) {
			return true;
		}
		if (obj.getClass() != getClass()) {
			return false;
		}
		Pizza rhs = (Pizza) obj;
		return new EqualsBuilder().append(code, rhs.code).append(nom, rhs.nom).append(prix, rhs.prix).isEquals();
	}

	public Pizza() {
		super();
		// nbPizzas++;
		// TODO Auto-generated constructor stub
	}

	public int getNbPizzas() {
		return nbPizzas;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public Double getPrix() {
		return prix;
	}

	public void setPrix(Double prix) {
		this.prix = prix;
	}

	@Override
	public String toString() {
		return "Pizza [id=" + id + ", code=" + code + ", nom=" + nom + ", prix=" + prix + "]\n";
	}

}
