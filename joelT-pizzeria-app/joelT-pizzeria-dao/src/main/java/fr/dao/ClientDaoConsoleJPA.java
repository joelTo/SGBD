package fr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import fr.model.Client;
import fr.model.Pizza;

public class ClientDaoConsoleJPA implements ClientDaoFactory {
	private EntityManagerFactory emf;
	@PersistenceUnit(unitName = "joelT-pizzeria-console")
	private EntityManager em;

	public ClientDaoConsoleJPA() {
		this.emf = Persistence.createEntityManagerFactory("joelT-pizzeria-console");

	}

	@Override
	public List<Pizza> findCommand() {

		return null;
	}

	@Override
	public void save(String newPizza, Integer nbPizza) {
		// Requete 1: Récuperer toutes les informations sur la pizza
		// Requete 2: rajouter son id + la quantité dans le commande
		/*
		 * vérifier que la table commande est bienle numero de client + la table
		 * de pizza associé au numero de commande
		 */
	}

	@Override
	public void delete(String Commande, Integer nbPizza) {
		// Requete 1 : Trouver la commande
		// regarder son statut
		// retourne possible ...
	}

	@Override
	public void update(String pizzaUdate, Integer nbPizza) {

	}

	@Override
	public void signIn(Client pers) {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(pers);
		et.commit();
		em.close();
	}

	@Override
	public void connection(String email, String password) {
		// Faire une requete preparer avec email et le mot de passe WHERE

	}

	public List<Pizza> findAllPizza() {
		em = emf.createEntityManager();
		TypedQuery<Pizza> empizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		return empizza.getResultList();
	}
}
