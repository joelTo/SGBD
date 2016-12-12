package fr.dao;

import java.sql.SQLException;
import java.util.List;

import fr.exception.DeletePizzaException;
import fr.exception.SavePizzaException;
import fr.exception.UpdatesPizzaException;
import fr.model.Pizza;

public interface PizzaDaoFactory {

	List<Pizza> findAll() throws SQLException;

	void save(Pizza newPizza) throws SavePizzaException, SQLException;

	void delete(String pizzaToDelete) throws DeletePizzaException;

	void update(Pizza pizzaUdate, String oldCode) throws UpdatesPizzaException, SQLException;

}
