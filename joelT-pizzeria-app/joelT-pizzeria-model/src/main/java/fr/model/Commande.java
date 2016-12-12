package fr.model;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class Commande {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@ManyToMany
	@JoinTable(name = "COMMANDE_PIZZA", joinColumns = @JoinColumn(name = "COMMANDE_ID", referencedColumnName = "ID"), inverseJoinColumns = @JoinColumn(name = "PIZZA_ID", referencedColumnName = "ID"))
	private List<Pizza> pizzas = new ArrayList<>();

	@Column(name = "NUMERO_COMMANDE", length = 30, nullable = false, unique = true)
	private Integer numero_commande;
	@Enumerated(EnumType.STRING)
	private StatutCommande statut;
	@Column(name = "DATE", length = 30, nullable = false)
	private String date;

	@ManyToOne
	@JoinColumn(name = "livreur_id")
	private Livreur livreur;

	@ManyToOne
	@JoinColumn(name = "client_id")
	private Client client;

}
