package fr.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;

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

	}

	@Override
	public void delete(String pizzaToDelete, Integer nbPizza) {

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

	}

}
