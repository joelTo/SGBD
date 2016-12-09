package fr.dao;

import java.sql.SQLException;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.PersistenceUnit;
import javax.persistence.TypedQuery;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

public class PizzaDaoBaseJPA implements PizzaDaoFactory {
	private EntityManagerFactory emf;
	@PersistenceUnit(unitName = "joelT-pizzeria-console")
	private EntityManager em;

	public PizzaDaoBaseJPA() {
		this.emf = Persistence.createEntityManagerFactory("joelT-pizzeria-console");

	}

	@Override
	public List<Pizza> findAll() throws SQLException {
		em = emf.createEntityManager();
		TypedQuery<Pizza> empizza = em.createQuery("SELECT p FROM Pizza p", Pizza.class);
		return empizza.getResultList();
	}

	@Override
	public void save(Pizza newPizza) throws SavePizzaException, SQLException {
		EntityTransaction et = em.getTransaction();
		et.begin();
		em.persist(newPizza);
		et.commit();
		em.close();
	}

	public Pizza findByCode(String codePizza) {
		return em.createNamedQuery("code.findByCode", Pizza.class).setParameter("name", codePizza).getSingleResult();
	}

	@Override
	public void delete(String pizzaToDelete) throws DeletePizzaException {
		Pizza emp = findByCode(pizzaToDelete);
		System.out.println("La " + emp + "va être modifié");

		if (emp != null) {
			EntityTransaction et = em.getTransaction();
			et.begin();
			em.remove(emp);
			et.commit();
			em.close();

		}

	}

	@Override
	public void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException, SQLException {
		Pizza emp = findByCode(oldCode);
		if (emp != null) {
			EntityTransaction et = em.getTransaction();
			System.out.println("On est passe par iuci");
			et.begin();
			em.persist(pizzaUdate);
			et.commit();
			em.close();

		}
	}

}
